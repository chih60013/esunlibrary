package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.member.Member;
import com.esun.library.models.services.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	

	
//	註冊會員
	@GetMapping("/member/register")
	public String addMember(Member member ,Model model) {
		model.addAttribute("member", member);
		return "member/addMember";
		
	}
	
	@PostMapping("/member/post")
	public String postMember(@ModelAttribute("member") Member member,Model model ) {
		memberService.addMember(member);
		model.addAttribute("member",member);
		return "redirect:/member/memberAll";
		
	}
	
	
	
	//讀取所有會員資料
	@GetMapping("/member/memberAll")
	public String showAllMember(Model model) {
		List<Member> findAllMember = memberService.findAllMember();
		
		model.addAttribute("memberList",findAllMember);
		return "/member/memberAll";
		
	}
	
	
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}

}
