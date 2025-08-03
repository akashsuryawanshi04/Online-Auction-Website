package com.tech.entities;

/**
 *
 * @author akash_codeit04x
 */
public class Product {
    private int productId;
    private String productName;
    private String description;
    private String bidder;
    private String seller;
    private String imageLocation;
    private double price;
    private String type;

    public Product() {
    }

    // Constructor
    public Product( String productName, String description, String bidder, String seller, String imageLocation, double price, String type) {
        
        this.productName = productName;
        this.description = description;
        this.bidder = bidder;
        this.seller = seller;
        this.imageLocation = imageLocation;
        this.price = price;
        this.type = type;
    }

    public Product(String productName, String imageLocation, double price, String type) {
        this.productName = productName;
        this.imageLocation = imageLocation;
        this.price = price;
        this.type = type;
    }

    public Product(String productName, String description, String imageLocation, double price) {
        this.productName = productName;
        this.description = description;
        this.imageLocation = imageLocation;
        this.price = price;
    }

    public Product(String productName, String description, String seller, String imageLocation, double price, String type) {
        this.productName = productName;
        this.description = description;
        this.seller = seller;
        this.imageLocation = imageLocation;
        this.price = price;
        this.type = type;
    }

    public Product(int productId, String productName, double price, String description, String imagelocation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
