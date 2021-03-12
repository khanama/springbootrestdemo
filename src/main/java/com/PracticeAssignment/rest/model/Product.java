package com.PracticeAssignment.rest.model;

public class Product {
	
	public static final String CURRENCY = "EUR";

    public static String getCurrency() {
		return CURRENCY;
	}

	public Product() {

    }

    public Product(Integer id, String prodName, String prodDesc, double price) {
        super();
        this.id = id;
        this.productName = prodName;
        this.productDesc = prodDesc;
        this.price = price;        
    }
 
    private Integer id;
    private String productName;
    private String productDesc;
    private double price;

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", productDescription=" + productDesc + ", price=" + price + ",currency=" + CURRENCY + "]";
    }
}
