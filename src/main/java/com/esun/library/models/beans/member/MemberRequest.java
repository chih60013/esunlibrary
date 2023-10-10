package com.esun.library.models.beans.member;

public class MemberRequest {
	
	private String memberPhoneNumber;
    private String memberPassword;
    private String verification;
	
	
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


	public String getVerification() {
		return verification;
	}


	public void setVerification(String verification) {
		this.verification = verification;
	}


	public MemberRequest() {
		// TODO Auto-generated constructor stub
	}

}
