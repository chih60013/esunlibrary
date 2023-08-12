package com.esun.library.models.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
	
	
	Optional<Member> findByMemberPhoneNumber(String memberPhoneNumber);
	
	
}

