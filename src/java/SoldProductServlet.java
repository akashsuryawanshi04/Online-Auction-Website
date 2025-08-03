/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author amitp_s2vptkn
 */
@WebServlet("/SoldProductServlet")
public class SoldProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

            // Prepare SQL statement for inserting sold product
            String insertSql = "INSERT INTO sold_products (product_name, description, bidder, seller, price, image_location)\n" +
                               "SELECT product_name, description, bidder, seller, price, image_location\n" +
                               "FROM products\n" +
                               "WHERE product_id = ?";
            stmt1 = conn.prepareStatement(insertSql);
            stmt1.setString(1, id);
            
            // Execute insert query
            int rowsInserted = stmt1.executeUpdate();

            if (rowsInserted > 0) {
                // Prepare delete statements
                String deleteSql1 = "DELETE FROM products WHERE product_id = ?";
                stmt2 = conn.prepareStatement(deleteSql1);
                stmt2.setString(1, id);
                stmt2.executeUpdate();
                
                // Redirect to bill.jsp
                response.sendRedirect("bill.jsp");
            } else {
                // If the product doesn't exist, show error message
                out.println("<h3>Product with ID " + id + " does not exist</h3>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all database resources
            try {
                if (stmt1 != null)
                    stmt1.close();
                if (stmt2 != null)
                    stmt2.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for selling products";
    }
}
