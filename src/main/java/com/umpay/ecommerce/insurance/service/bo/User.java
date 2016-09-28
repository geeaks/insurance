package com.umpay.ecommerce.insurance.service.bo;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 5081352235005252044L;

	private String name;
	
	private String password;
	
	private String sex;
	
	private String age;
	
	public User(String name, String sex, String age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
}
