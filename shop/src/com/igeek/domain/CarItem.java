package com.igeek.domain;

public class CarItem {
	private Product product;
	private int buyNum;
	private double subTotal;
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public CarItem() {
		super();
		// TODO Auto-generated constructor stub
	}
}
