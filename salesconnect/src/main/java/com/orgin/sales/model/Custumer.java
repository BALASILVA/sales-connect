package com.orgin.sales.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Custumer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 132210838292886788L;
	@Id
	String Id;
	String custumerPhone;
	public Custumer() {
		// TODO Auto-generated constructor stub
	}
	public Custumer(String id, String custumerPhone) {
		super();
		Id = id;
		this.custumerPhone = custumerPhone;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCustumerPhone() {
		return custumerPhone;
	}
	public void setCustumerPhone(String custumerPhone) {
		this.custumerPhone = custumerPhone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Custumer [Id=" + Id + ", custumerPhone=" + custumerPhone + "]";
	}
	
	}
