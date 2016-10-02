package com.java.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity 
@Table (name="USER_DETAIL")
public class UserDetails {
	
	@Id @GeneratedValue
	@Column (name="USER_ID")
	private int userId;
	@Column (name="USER_NAME")
	private String UserName;
	
	@Embedded
	private AddressDetails homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY")),
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="pinCode",column=@Column(name="OFFICE_PINCODE"))})
	private AddressDetails officeAddress;

		
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public AddressDetails getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(AddressDetails homeAddress) {
		this.homeAddress = homeAddress;
	}

	public AddressDetails getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(AddressDetails officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
