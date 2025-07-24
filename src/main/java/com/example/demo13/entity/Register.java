package com.example.demo13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Register2")
public class Register {
	@Id
	private String email;
	private String pwd;
	private String phone;
	private String gender;
	private String desig="user";
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(String email, String pwd, String phone, String gender) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.phone = phone;
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	@Override
	public String toString() {
		return "Register [email=" + email + ", pwd=" + pwd + ", phone=" + phone + ", gender=" + gender + ", desig="
				+ desig + "]";
	}
	
	
}
