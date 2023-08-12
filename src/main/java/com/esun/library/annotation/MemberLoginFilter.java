package com.esun.library.annotation;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esun.library.models.beans.member.MemberNullException;




@Aspect
@Component
public class MemberLoginFilter {

	@Autowired
	HttpSession httpSession;
	
//	@Before("@annotation(com.esun.library.annotation.memberLogin)")
//	public void MemberLoginMeth() {
//		Object attribute = httpSession.getAttribute("member");
//		if(attribute == null) {
//			throw new MemberNullException();
//		}
//	}
	
	
}
