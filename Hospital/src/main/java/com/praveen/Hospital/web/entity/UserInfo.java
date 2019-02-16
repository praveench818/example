package com.praveen.Hospital.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class UserInfo {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 
   
	
	@Column(name = "username")
	private String username;
	
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////	


	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + "]";
	}


	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
