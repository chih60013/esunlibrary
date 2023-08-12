package com.esun.library.models.beans.member;

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
@Table(name="member")
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="member_Id")
	private Integer memberId;
	
	
	@NotBlank
    @Column(name="member_PhoneNumber",nullable = false,unique = true)
    private String memberPhoneNumber; 

	@NotBlank
    @Column(name="member_Password", columnDefinition = "nvarchar(20)",nullable = false)
    private String memberPassword; 
    
	@NotBlank
    @Column(name="member_Name", columnDefinition = "nvarchar(30)",nullable = false)
    private String memberName; 
	


    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "member_RegistrationTime", columnDefinition = "datetime")
    private Date memberRegistrationTime; // 註冊日期時間

    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name="member_LastLoginTime", columnDefinition = "datetime")
    private Date memberLastLoginTime; // 最後登入日期時間
	
	
    @PrePersist
	@PreUpdate
	public void onCreateOrUpdate() {
	    if (memberRegistrationTime == null) {
	    	memberRegistrationTime = new Date();
	    }
	    if (memberLastLoginTime == null) {
	    	memberLastLoginTime = new Date();
	    } else {
	    	memberLastLoginTime = new Date();
	    }
	}


	public Integer getMemberId() {
		return memberId;
	}


	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}


	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}


	public String getMemberPassword() {
		return memberPassword;
	}


	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}




	public Date getMemberRegistrationTime() {
		return memberRegistrationTime;
	}


	public void setMemberRegistrationTime(Date memberRegistrationTime) {
		this.memberRegistrationTime = memberRegistrationTime;
	}


	public Date getMemberLastLoginTime() {
		return memberLastLoginTime;
	}


	public void setMemberLastLoginTime(Date memberLastLoginTime) {
		this.memberLastLoginTime = memberLastLoginTime;
	}
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
}
