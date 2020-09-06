package com.orgin.sales.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -80685800155682662L;
	@Id
	private String id;
	private long adminId;
	private long  userId;
	private String name;
	private String gender;
	private int age;
	private Date joinDate;
	private String role;
	private String phoneNumber;
	private String phoneNumberWithDialCode;
	private String email;
	private String userName;
	private String password;
	private boolean enable;

	public User() {
	}

	public User(String id, long adminId, long userId, String name, String gender, int age, Date joinDate, String role,
			String phoneNumber, String phoneNumberWithDialCode, String email, String userName, String password,
			boolean enable) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.joinDate = joinDate;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.phoneNumberWithDialCode = phoneNumberWithDialCode;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.enable = enable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberWithDialCode() {
		return phoneNumberWithDialCode;
	}

	public void setPhoneNumberWithDialCode(String phoneNumberWithDialCode) {
		this.phoneNumberWithDialCode = phoneNumberWithDialCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", adminId=" + adminId + ", userId=" + userId + ", name=" + name + ", gender="
				+ gender + ", age=" + age + ", joinDate=" + joinDate + ", role=" + role + ", phoneNumber=" + phoneNumber
				+ ", phoneNumberWithDialCode=" + phoneNumberWithDialCode + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", enable=" + enable + "]";
	}
	
		
}