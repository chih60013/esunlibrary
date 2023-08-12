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

	// 檢查電話號碼是否重複
	public boolean isAccountDuplicate(String memberPhoneNumber) {
		// 在 Repository 中查詢是否有相同的帳號（電話號碼）
		Optional<Member> existingMember = memberRepository.findByMemberPhoneNumber(memberPhoneNumber);
		return existingMember != null; // 如果存在，則帳號重複
	}

	// 新增會員
	public void addMember(Member member) {
		if (isAccountDuplicate(member.getMemberPhoneNumber())) {
			
		} else {

			memberRepository.save(member);
		}
		;
	}

	// 找尋所有會員
	public List<Member> findAllMember() {
		List<Member> findAllMember = memberRepository.findAll();
		return findAllMember;
	}

}
