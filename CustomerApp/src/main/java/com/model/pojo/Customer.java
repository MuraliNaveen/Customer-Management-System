package com.model.pojo;

public class Customer {

	
	 private int id;
	 private String Name;
	 private String email;
	 private String Mobile;
	 private String city;
	public Customer() {
		super();
	}
	public Customer(String name, String email, String mobile, String city) {
		super();
		Name = name;
		this.email = email;
		Mobile = mobile;
		this.city = city;
	}
	public Customer(int id, String name, String email, String mobile, String city) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		Mobile = mobile;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", Name=" + Name + ", email=" + email + ", Mobile=" + Mobile + ", city=" + city
				+ "]";
	}
	 
}
