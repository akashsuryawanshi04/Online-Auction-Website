<%-- 
    Document   : ShowDetail
    Created on : 03-Mar-2024, 6:09:40 pm
    Author     : amitp_s2vptkn
--%>

<%@page import="java.util.List"%>
<%@page import="com.tech.entities.Product"%>
<%@page import="com.tech.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>AuctionFlow</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel=" stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
     <style>
    .button-container {
        display: inline;
      }

    .button-container form {
        display: inline;
      }
     </style>
        
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
   <body class="main-layout inner_page">
      <!-- loader  -->
      <!-- <div class="loader_bg">
         <div class="loader"><img src="images/loading.gif" alt="#"/></div>
      </div> -->
      <!-- end loader -->
      <!-- header -->
      
     <%
         
         String email = (String) session.getAttribute("email");
         String id  = request.getParameter("productId");
         String name  = request.getParameter("name");
         String descri  = request.getParameter("descrip");
         String price  = request.getParameter("price");
         String image  = request.getParameter("image");
          String bidder  = request.getParameter("bidder");
          String seller  = request.getParameter("seller");
          String typ =request.getParameter("ty");
          String massage="";
     %>
      
      <header class="full_bg">
         <!-- header inner -->
         <div class="header">
            <div class="header_top">
               <div class="container">
                  <div class="row">
                     <div class="col-md-3">
                        <ul class="contat_infoma">
                           <li><i class="fa fa-phone" aria-hidden="true"></i> Call : +01 12345678909</li>
                        </ul>
                     </div>
                     <div class="col-md-6">
                        <ul class="social_icon_top text_align_center  ">
                           <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                           <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                           <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                           <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        </ul>
                     </div>
                     <div class="col-md-3">
                        <ul class="contat_infoma text_align_right">
                           <li><a href="Javascript:void(0)"> <i class="" aria-hidden="true"></i> <%=email%></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <div class="header_bottom">
                        <div class="row">
                           <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                              <div class="full">
                                 <div class="center-desk">
                                    <div class="logo">
                                       <a href="index.html">AuctionFlow</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                              <nav class="navigation navbar navbar-expand-md navbar-dark ">
                                 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                                 <span class="navbar-toggler-icon"></span>
                                 </button>
                                 <div class="collapse navbar-collapse" id="navbarsExample04">
                                    <ul class="navbar-nav mr-auto">
                                       <li class="nav-item active">
                                          <a class="nav-link" href="index.html">Home</a>
                                       </li>
                                       <li class="nav-item">
                                          <a class="nav-link" href="bill.jsp">User</a>
                                       </li>
                                       
                                    </ul>
                                 </div>
                              </nav>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- end header inner -->
         <!-- end header -->
         <!-- banner -->
      </header>
      <div class="back_re">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="title">
                     <h2>Product DETAILS</h2>
                  </div>
               </div>
            </div>
         </div>
    </div>
     
    
      <!-- Main page -->
      <div class="ip-container">
           
          
          
        <!-- Product Details Section -->
        <section class="ip-product-details">
            
            
             
          
            <div class="ip-product-image">
                <img src="<%=image%>" alt="Product Name" style=" height: 500px;">
            </div>
            <div class="ip-product-info">
                <h2><%=name%></h2>
                <p class="ip-product-description"><%=descri%></p>
                <p class="ip-base-price" id="base-price"><%=price%></p> <!-- Base Price of the product -->
                <!-- Link to your bidding action -->
                    <!-- You can add more options for size, color, quantity, etc. -->
           
                    
 <%
if(email == null) {
%>
    <p style="color: red">YOU ARE NOT LOGGED IN, LOGIN FIRST</p>
    <a href="login.html" class="ip-bid-now-button" style="width:96px; height: 55.6px;background-color: #fe9901;"><p style="color:#ffffff">LOGIN</p></a>
<%
} else {
    if(email.equals(seller)) {
%>
    <form action="SoldProductServlet" >
        <input type="hidden" name="id" value="<%=id%>">
        <button type="submit" class="ip-bid-now-button" id="AcceptOffer">ACCEPT OFFER</button>
    </form>

    <div class="button-container">
<%
    } else if(typ != null && typ.equals("cart")) {
%>
    <div class="button-container">
        <form action="UpdateBidServlet" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="user" value="<%=email%>">
            <input type="number" name="bid-amount" id="bid-amount" placeholder="Enter your bid amount" required>
            <button type="submit" class="ip-bid-now-button" id="bid-button">Place Bid</button>
        </form>

        <form action="RemoveCartServlet" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="user" value="<%=email%>">
            <button type="submit" class="ip-bid-now-button" id="remove-from-cart-button">REMOVE FROM CART</button>
        </form>
    </div>
<%
    } else {
%>
    <div class="button-container">
        <form action="UpdateBidServlet" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="user" value="<%=email%>">
            <input type="number" name="bid-amount" id="bid-amount" placeholder="Enter your bid amount" required>
            <button type="submit" class="ip-bid-now-button" id="bid-button">Place Bid</button>
        </form>

        <form action="AddCartItemServlet" method="post">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="user" value="<%=email%>">
            <button type="submit" class="ip-bid-now-button" id="add-to-cart-button">ADD TO CART</button>
        </form>
    </div>
<%
    }
}
%>


             
                 
            </div>
                
                 
                 
        </section>
               
    </div>


      <!-- end Main page -->
      <!--  footer -->
      <footer>
         <div class="footer">
            <div class="container">
               <div class="row">

               </div>
            </div>
            <div class="copyright">
               <div class="container">
                  <div class="row">
                     <div class="col-md-8 offset-md-2">
                        <p>© 2024 All Rights Reserved.</p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </footer>
      
    
   </body>
</html>
