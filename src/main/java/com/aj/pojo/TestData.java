package com.aj.pojo;

public class TestData {
	
	String productName;
	String productSize;
	String productColor;
	
	public TestData(String productName, String productSize, String productColor) {
		super();
		this.productName = productName;
		this.productSize = productSize;
		this.productColor = productColor;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	
	

}
