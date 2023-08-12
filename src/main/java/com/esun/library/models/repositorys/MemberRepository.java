package com.esun.library.models.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
	
}

