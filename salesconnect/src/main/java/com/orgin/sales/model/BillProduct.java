package com.orgin.sales.model;

import java.io.Serializable;

public class BillProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -853307482509446544L;
	long price;
	long productId;
	String productName;
	long quantity;

	public BillProduct() {
	}

	public BillProduct(long price, long productId, String productName, long quantity) {
		super();
		this.price = price;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillProduct [price=" + price + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}
	
}
