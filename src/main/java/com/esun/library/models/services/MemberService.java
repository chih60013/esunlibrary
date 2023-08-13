package com.esun.library.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.member.Member;
import com.esun.library.models.repositorys.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	
	
	public boolean isAccountDuplicate(String memberPhoneNumber) {
        Optional<Member> existingMember = memberRepository.findByMemberPhoneNumber(memberPhoneNumber);
        return existingMember.isPresent(); // 如果存在，則帳號重複
    }

    public void addMember(Member member) {
        if (isAccountDuplicate(member.getMemberPhoneNumber())) {
            throw new RuntimeException("輸入號碼重複，已註冊過，請重新確認"); 
        } else {
            memberRepository.save(member);
        }
    }
	
	

	// 找尋所有會員
	public List<Member> findAllMember() {
		List<Member> findAllMember = memberRepository.findAll();
		return findAllMember;
	}

}
