package com.ute.an.model;

import java.util.Date;

public class Employee {
	protected String id;
	protected String name;
	protected String sex;
	protected String bDate;
	protected String homeTown;
	protected String phone;
	protected String address;
	protected String status;
	public Employee() {
	}
	public Employee(String id, String name, String sex, String bDate, String homeTown, String phone, String address,
			String status) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.bDate = bDate;
		this.homeTown = homeTown;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", bDate=" + bDate + ", homeTown=" + homeTown
				+ ", phone=" + phone + ", address=" + address + ", status=" + status + "]";
	}
	
	
}
