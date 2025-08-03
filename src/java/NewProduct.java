import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/NewProduct")
@MultipartConfig(maxFileSize = 16177215) // 16 MB
public class NewProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/on_product";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final String UPLOAD_DIRECTORY = "D:\\java_project\\Action_\\web\\images\\products";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String buyerEmail = email; // Default seller email
        
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String type = request.getParameter("type"); // Retrieve product type
        Part filePart = request.getPart("picture");
        
        String fileName = extractFileName(filePart);
        String savePath = UPLOAD_DIRECTORY + File.separator + fileName;
        
        InputStream inputStream = filePart.getInputStream();
        saveFile(inputStream, savePath);
        
        // Calculate the relative path of the image
        String relativePath = "images" + File.separator +"products"+File.separator+ fileName;
        
        Connection conn = null;
        String message = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String sql = "INSERT INTO products (product_name, price, image_location, description, seller,type) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setDouble(2, price);
            statement.setString(3, relativePath);
            statement.setString(4, description);
            statement.setString(5, buyerEmail);
             statement.setString(6, type); // Set product type
            
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Product added successfully!";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
    
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    
    private void saveFile(InputStream inputStream, String path) {
        try (OutputStream outputStream = new FileOutputStream(new File(path))) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
