package com.shop.life.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserStory")
public class UserEntity implements Serializable{

	@Id
	private String UserEmail;
	private String UserName;
	private String UserPassword;
	private String MobileNumber;
	   
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "userEntity")
	private List<CartEntity> cartEntity;
	
	public UserEntity() {
	
	}

	public UserEntity(String userName, String userEmail, String userPassword, String mobileNumber) {
		super();
		UserName = userName;
		UserEmail = userEmail;
		UserPassword = userPassword;
		MobileNumber = mobileNumber;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserEntity [UserName=" + UserName + ", UserEmail=" + UserEmail + ", UserPassword=" + UserPassword
				+ ", MobileNumber=" + MobileNumber + "]";
	}
	
}
