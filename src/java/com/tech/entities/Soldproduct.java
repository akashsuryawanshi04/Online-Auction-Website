package com.tech.entities;

/**
 *
 * @author akash_codeit04x
 */
public class Soldproduct {
    private int s_productId;
    private String s_productName;
    private String s_description;
    private String s_bidder;
    private String s_seller;
    private String s_imageLocation;
    private double s_price;
    private String s_type;

    public Soldproduct(String s_productName, String s_description, String s_imageLocation, double s_price, String s_type) {
        this.s_productName = s_productName;
        this.s_description = s_description;
        this.s_imageLocation = s_imageLocation;
        this.s_price = s_price;
        this.s_type = s_type;
    }

    
    
    
    
    public int getS_productId() {
        return s_productId;
    }

    public void setS_productId(int s_productId) {
        this.s_productId = s_productId;
    }

    public String getS_productName() {
        return s_productName;
    }

    public void setS_productName(String s_productName) {
        this.s_productName = s_productName;
    }

    public String getS_description() {
        return s_description;
    }

    public void setS_description(String s_description) {
        this.s_description = s_description;
    }

    public String getS_bidder() {
        return s_bidder;
    }

    public void setS_bidder(String s_bidder) {
        this.s_bidder = s_bidder;
    }

    public String getS_seller() {
        return s_seller;
    }

    public void setS_seller(String s_seller) {
        this.s_seller = s_seller;
    }

    public String getS_imageLocation() {
        return s_imageLocation;
    }

    public void setS_imageLocation(String s_imageLocation) {
        this.s_imageLocation = s_imageLocation;
    }

    public double getS_price() {
        return s_price;
    }

    public void setS_price(double s_price) {
        this.s_price = s_price;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }
    
    
    
    
    
    
    
}


    
