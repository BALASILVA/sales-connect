package com.orgin.sales.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;

public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9017315636259067734L;
	@Id
	String Id;
	long adminId;
	String customerId;
	String custumerPhone;
	long totalPrice;
	List<BillProduct> product = new ArrayList<BillProduct>();
	Date billDate;

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(String id, long adminId, String customerId, String custumerPhone, long totalPrice,
			List<BillProduct> product, Date billDate) {
		super();
		Id = id;
		this.adminId = adminId;
		this.customerId = customerId;
		this.custumerPhone = custumerPhone;
		this.totalPrice = totalPrice;
		this.product = product;
		this.billDate = billDate;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustumerPhone() {
		return custumerPhone;
	}

	public void setCustumerPhone(String custumerPhone) {
		this.custumerPhone = custumerPhone;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<BillProduct> getProduct() {
		return product;
	}

	public void setProduct(List<BillProduct> product) {
		this.product = product;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bill [Id=" + Id + ", adminId=" + adminId + ", customerId=" + customerId + ", custumerPhone="
				+ custumerPhone + ", totalPrice=" + totalPrice + ", product=" + product + ", billDate=" + billDate
				+ "]";
	}

}
