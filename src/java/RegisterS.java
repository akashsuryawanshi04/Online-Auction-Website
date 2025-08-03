import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterS")
public class RegisterS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Database connectivity details
        String url = "jdbc:mysql://localhost:3306/on_product"; // Update with your database URL
        String dbUser = "root"; // Update with your database username
        String dbPassword = ""; // Update with your database password

        Connection conn = null;
        PreparedStatement checkStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            
            // Check if the email already exists
            String checkSql = "SELECT * FROM users WHERE email = ?";
            checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, email);
            resultSet = checkStmt.executeQuery();

            if (resultSet.next()) {
                // Email already exists, inform the user
                out.println("<html><body>");
                out.println("<h2>Registration Failed!</h2>");
                out.println("<p>Email already exists. Please choose another email.</p>");
                out.println("</body></html>");
            } else {
                // Email does not exist, proceed with registration
                String insertSql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.setString(3, email);
                
                // Execute the insertion statement
                int rowsInserted = insertStmt.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("login.html");
                    
                } else {
                    out.println("<html><body>");
                    out.println("<h2>Registration Failed!</h2>");
                    out.println("</body></html>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h2>Registration Failed!</h2>");
            out.println("</body></html>");
        } finally {
            // Close all resources
            try {
                if (resultSet != null) resultSet.close();
                if (checkStmt != null) checkStmt.close();
                if (insertStmt != null) insertStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
