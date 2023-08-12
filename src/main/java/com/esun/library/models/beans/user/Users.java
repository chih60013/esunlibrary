package com.esun.library.models.beans.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_Id")
	private Integer userId;
	
	
	@NotBlank
    @Column(name="user_PhoneNumber",nullable = false, unique = true)
    private String userPhoneNumber; 

    @NotBlank
    @Column(name="user_Password", columnDefinition = "nvarchar(20)",nullable = false)
    private String userPassword; 
    
    @NotBlank
    @Column(name="user_Name", columnDefinition = "nvarchar(30)",nullable = false)
    private String userName; 
    
    
	@Column(name="user_Token")
	private String userToken;

    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "user_RegistrationTime", columnDefinition = "datetime")
    private Date userRegistrationTime; // 註冊日期時間

    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name="user_LastLoginTime", columnDefinition = "datetime")
    private Date userLastLoginTime; // 最後登入日期時間
	

    
	
	@PrePersist
	@PreUpdate
	public void onCreateOrUpdate() {
	    if (userRegistrationTime == null) {
	    	userRegistrationTime = new Date();
	    }
	    if (userLastLoginTime == null) {
	    	userLastLoginTime = new Date();
	    } else {
	    	userLastLoginTime = new Date();
	    }
	}

	//針對註冊日期其最後登入日期及時間做紀錄。


	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}




	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}




	public String getUserPassword() {
		return userPassword;
	}




	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Date getUserRegistrationTime() {
		return userRegistrationTime;
	}

	public void setUserRegistrationTime(Date userRegistrationTime) {
		this.userRegistrationTime = userRegistrationTime;
	}

	public Date getUserLastLoginTime() {
		return userLastLoginTime;
	}




	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
    
    
}
