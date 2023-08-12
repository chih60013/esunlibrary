package com.esun.library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.member.Member;
import com.esun.library.models.repositorys.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	//新增會員
	public void addMember(Member member) {
		memberRepository.save(member);
	}
	
	
	//找尋所有會員
	public List<Member> findAllMember(){
		List<Member> findAllMember= memberRepository.findAll();
		return findAllMember;
	}
	
	
	
}
