import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBidServlet")
public class UpdateBidServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Extract parameters from the request
        String productIdStr = request.getParameter("id");
        String bidder = request.getParameter("user");
        String newBidStr = request.getParameter("bid-amount");

        // Check if any parameter is null
        if (productIdStr == null || bidder == null || newBidStr == null) {
            out.println("<h2>Missing parameter. Please provide all required parameters.</h2>");
            return; // Exit method
        }

        // Parse parameters to appropriate data types
        int productId = Integer.parseInt(productIdStr);
        double newBid = Double.parseDouble(newBidStr);

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

            // Prepare SQL statement
            String sql = "UPDATE products SET price = ?, bidder = ? WHERE product_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, newBid);
            stmt.setString(2, bidder);
            stmt.setInt(3, productId);

            // Execute update
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h2>Bid updated successfully!</h2>");
            } else {
                out.println("<h2>Failed to update bid.</h2>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
        } finally {
            // Close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(out);
            }
        }
    }
}
