package com.orgin.sales.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6119453419504296701L;
	
	@Transient
	public static final String SEQUENCE_NAME = "product_sequence";
	
	@Id
	private String id;
	private long productId;
	private String adminId;
	private String productName;
	private float price;
	private long stock;
	private long totalSale;
	private int tax1;
	private int tax2;
	public Product() {
	}
	public Product(String id, long productId, String adminId, String productName, float price, long stock,
			long totalSale, int tax1, int tax2) {
		super();
		this.id = id;
		this.productId = productId;
		this.adminId = adminId;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.totalSale = totalSale;
		this.tax1 = tax1;
		this.tax2 = tax2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public long getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(long totalSale) {
		this.totalSale = totalSale;
	}
	public int getTax1() {
		return tax1;
	}
	public void setTax1(int tax1) {
		this.tax1 = tax1;
	}
	public int getTax2() {
		return tax2;
	}
	public void setTax2(int tax2) {
		this.tax2 = tax2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", adminId=" + adminId + ", productName="
				+ productName + ", price=" + price + ", stock=" + stock + ", totalSale=" + totalSale + ", tax1=" + tax1
				+ ", tax2=" + tax2 + "]";
	}

}


