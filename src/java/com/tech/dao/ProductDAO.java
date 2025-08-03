package com.tech.dao;
import com.tech.entities.Product;
import com.tech.helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Method to retrieve product data from the database
    public List<Product> getAllProducts() throws ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        try {
            // Establish database connection 
            Class.forName("com.mysql.jdbc.Driver");
            //connection with database 
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product","your_database_username","pasword");
            

            // SQL query to retrieve all products
            String sql = "SELECT * FROM products ";
            
            // Prepare statement
            stmt = conn.prepareStatement(sql);
            
            // Execute query
            rs = stmt.executeQuery();
            
            // Iterate through the result set and populate products list
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setBidder(rs.getString("bidder"));
                product.setSeller(rs.getString("seller"));
                product.setImageLocation(rs.getString("image_location"));
                product.setPrice(rs.getDouble("price"));
                product.setType(rs.getString("type"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            // Close resources in finally block
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }
    
    
    // program to display product for specific type 
    public List<Product> getAllProducts(String productType) throws ClassNotFoundException {
    List<Product> products = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Establish database connection 
        Class.forName("com.mysql.jdbc.Driver");
        //connection with database 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

        // SQL query to retrieve products based on type
        String sql = "SELECT * FROM products WHERE type = ?";
        
        // Prepare statement with parameter for type
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, productType);

        // Execute query
        rs = stmt.executeQuery();

        // Iterate through the result set and populate products list
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setDescription(rs.getString("description"));
            product.setBidder(rs.getString("bidder"));
            product.setSeller(rs.getString("seller"));
            product.setImageLocation(rs.getString("image_location"));
            product.setPrice(rs.getDouble("price"));
            product.setType(rs.getString("type"));
            products.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return products;
}
    
  
    
// program to fetch cart items 
  public List<Product> getcart(String user) throws ClassNotFoundException {
    List<Product> products = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Establish database connection 
        Class.forName("com.mysql.jdbc.Driver");
        //connection with database 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

        // SQL query to retrieve products based on type
         String sql = "SELECT p.product_id, p.product_name, p.description, p.bidder, p.seller, p.image_location, p.price, p.type " +
                         "FROM products p " +
                         "INNER JOIN cart c ON p.product_id = c.Product_id " +
                         "WHERE c.user = ?";
        
        // Prepare statement with parameter for type
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);

        // Execute query
        rs = stmt.executeQuery();

        // Iterate through the result set and populate products list
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setDescription(rs.getString("description"));
            product.setBidder(rs.getString("bidder"));
            product.setSeller(rs.getString("seller"));
            product.setImageLocation(rs.getString("image_location"));
            product.setPrice(rs.getDouble("price"));
            product.setType(rs.getString("type"));
            products.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return products;
}  



// program to fetch data for bidder 

 public List<Product> getbidproduct(String bider) throws ClassNotFoundException {
    List<Product> products = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Establish database connection 
        Class.forName("com.mysql.jdbc.Driver");
        //connection with database 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

        // SQL query to retrieve products based on type
        String sql = "SELECT * FROM products WHERE bidder= ?";
        
        // Prepare statement with parameter for type
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, bider);

        // Execute query
        rs = stmt.executeQuery();

        // Iterate through the result set and populate products list
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setDescription(rs.getString("description"));
            product.setBidder(rs.getString("bidder"));
            product.setSeller(rs.getString("seller"));
            product.setImageLocation(rs.getString("image_location"));
            product.setPrice(rs.getDouble("price"));
            product.setType(rs.getString("type"));
            products.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return products;
}  
    
 
 // program to fetch data for seller
 
  public List<Product> getsell(String sell) throws ClassNotFoundException {
    List<Product> products = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Establish database connection 
        Class.forName("com.mysql.jdbc.Driver");
        //connection with database 
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/on_product", "root", "");

        // SQL query to retrieve products based on type
        String sql = "SELECT * FROM products WHERE seller = ?";
        
        // Prepare statement with parameter for type
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, sell);

        // Execute query
        rs = stmt.executeQuery();

        // Iterate through the result set and populate products list
        while (rs.next()) {
            Product product = new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setDescription(rs.getString("description"));
            product.setBidder(rs.getString("bidder"));
            product.setSeller(rs.getString("seller"));
            product.setImageLocation(rs.getString("image_location"));
            product.setPrice(rs.getDouble("price"));
            product.setType(rs.getString("type"));
            products.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception
    } finally {
        // Close resources in finally block
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return products;
}  
  
  
  
  
  
  
  // method to fetch data for cart 
  
    


    
    
    public String protype(String type)
    {
        String ty ;
       String  protype="";
          ty=type;
          int no=Integer.parseInt(ty);
          switch(no)
          {
              case 1:
                  protype="Antiques Art";
              break;
              case 2:
                  protype="Decorative Items";
              break;  
              case 3:
                  protype="Tools & Equipments";
              break; 
              case 4:
                  protype="Clocks & Timepieces";
              break; 
              case 5:
                  protype="Painting";
              break; 
              case 6:
                  protype="Sculpture";
              break; 
              case 7:
                  protype="Digital Art";
              break; 
              case 8:
                  protype="Textiles & Clothes";
              break; 
              case 9:
                  protype="Currency";
              break; 
              case 10:
                  protype="Stamps";
              break; 
              case 11:
                  protype="Sports Memorabilla";
              break; 
              case 12:
                  protype="Trading cards";
              break; 
                     
                  
          }
          return protype;
    }


}
    
    
    
   

