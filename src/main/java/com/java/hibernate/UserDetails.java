package com.java.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="USER_DETAIL")
public class UserDetails {
	
	private int userId;
	private String UserName;

	@Id
	@Column (name="USER_ID")	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column (name="USER_NAME")
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

}
