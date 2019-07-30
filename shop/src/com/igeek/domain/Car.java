package com.igeek.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {
	private Map<String,CarItem> carItems = new HashMap<String,CarItem>();
	private double total;
	
	public Map<String, CarItem> getCarItems() {
		return carItems;
	}
	public void setCarItems(Map<String, CarItem> carItems) {
		this.carItems = carItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
