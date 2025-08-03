<%-- 
    Document   : bill
    Created on : 09-Mar-2024, 4:16:25 am
    Author     : amitp_s2vptkn
--%>

<%@page import="java.util.List"%>
<%@page import="com.tech.entities.Product"%>
<%@page import="com.tech.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 0;
        }

        .us-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .us-profile-bar {
            display: flex;
            align-items: center;
            background-color: #007bff;
            color: #fff;
            padding: 35px; /* Increased padding */
            border-radius: 10px;
            margin-bottom: 20px;

        }

        .us-profile-bar img {
            width: 90px; /* Increased width */
            height: 90px; /* Increased height */
            border-radius: 50%;
            margin-right: 20px;
            border: 1px solid black; /* Add border with color */
        }

        .us-profile-bar .us-username-container {
            display: flex;
            align-items: center;
        }

        .us-profile-bar .us-username {
            font-size: 40px; /* Adjust font size */
            font-weight: bold;
            margin-right: 30px; /* Add some spacing */
        }

        .us-edit-profile-button {
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .us-edit-profile-button:hover {
            background-color: #218838;
        }

        .us-section-title {
            color: #333;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .us-section {
            background-color: #f1f1f1;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .us-section p {
            color: #666;
            font-size: 16px;
            margin-bottom: 10px;
        }

        /* Additional styles for input fields */
        .us-edit-profile-form {
            display: none;
        }

        .us-edit-profile-form input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .us-edit-profile-form button {
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 8px 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .us-edit-profile-form button:hover {
            background-color: #218838;
        }
    </style>
     <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="us-container">

        <!-- Profile bar with edit profile button -->
        <div class="us-profile-bar" style="background-color: #fe9901;">
            
            <div class="us-username-container" >
                <span id="username" class="us-username">User Profile</span> <!-- Updated to include the username -->
               
            </div>
        </div>

       
<%
    String email = (String) session.getAttribute("email");

    // Check if the user is logged in
    boolean isLoggedIn = (session != null && session.getAttribute("email") != null);

    // Check if the user clicked on the logout button
    String logout = request.getParameter("logout");
    if (logout != null && logout.equals("true")) {
        // Invalidate the session
        if (session != null) {
            session.invalidate();
            response.sendRedirect("bill.jsp"); // Redirect to the main page after logout
            return; // Exit from this JSP to prevent further processing
        }
    }
%>

<!-- Profile information section -->
<div class="us-section">
    <div class="us-section-title"></div>
    <p><strong>Email:</strong> <span id="profile-email"><%=email%></span></p>

<% if (isLoggedIn) { %>
    <form action="bill.jsp">
        <input type="hidden" name="logout" value="true">
        <input type="submit" class="ip-bid-now-button" style="background-color: #fe9901;" value="Logout">
    </form>
<% } else { %>
    <form action="login.html">
        <input type="submit" class="ip-bid-now-button" style="background-color: #fe9901;" value="Login">
    </form>
<% } %>


            
        </div>
        <p><strong>YOUR BILLS:</strong>
            
              <% 
                
                  BidDAO productDAO = new BidDAO();
        List<Product> products = productDAO.getSoldProductsByEmail(email);
        for (Product product : products) {
            String imageSrc = request.getContextPath() + "/" + product.getImageLocation();
            int id = product.getProductId();
            String name = product.getProductName();
            String descrip = product.getDescription();
             String bidder = product.getBidder();
              String seller = product.getSeller();
            double price = product.getPrice();
           String image = product.getImageLocation().replace('\\', '/');;
        %>
        <div class="product" style="height:371px;" >
            <a href="BillPage.jsp?productId=<%=id%>&name=<%=name%>&price=<%=price%>&descrip=<%=descrip%>&image=<%=image%>&bidder=<%=bidder%>&seller=<%=seller%>" >
                <img src="<%= imageSrc %>" style=" width: 175px; height: 200px;" alt="Product Image">
                <h3><%= product.getProductName() %></h3>
                <p>Price: <%= product.getPrice() %></p>
                
            </a>
        </div>
        <% } %>
    </div>

    <!-- JavaScript for handling profile editing -->
   
</body>
</html>

