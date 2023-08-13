package com.esun.library.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.member.Member;
import com.esun.library.models.repositorys.MemberRepository;
import com.esun.library.models.services.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	
//	註冊會員	
	 @GetMapping("/member/register")
	    public String addMember(Member member, Model model) {
	        model.addAttribute("member", new Member());
	        return "member/addMember";
	    }

	    @PostMapping("/member/post")
	    public String postMember(@ModelAttribute("member") Member member, Model model) {
	        try {
	            memberService.addMember(member);
	            model.addAttribute("member", member);
	            return "redirect:/member/memberAll";
	        } catch (RuntimeException e) {
	            model.addAttribute("errorMessage", e.getMessage());
	            return "member/addMember"; // 返回註冊頁面並顯示錯誤訊息
	        }
	    }
	


	// 讀取所有會員資料
	@GetMapping("/member/memberAll")
	public String showAllMember(Model model) {
		List<Member> findAllMember = memberService.findAllMember();

		model.addAttribute("memberList", findAllMember);
		return "/member/memberAll";

	}

	// 會員登入
	@GetMapping("/member/login")
	public String loginMember(Model model, HttpSession session, HttpServletRequest request) {
		String previousUrl = request.getHeader("Referer");
		if (previousUrl != null && !previousUrl.contains("/member/login")) {
			session.setAttribute("previousUrl", previousUrl);
		}
		model.addAttribute("member", new Member());
		return "member/login";

	}

	@PostMapping("/member/login")
	public String postLoginMember(@ModelAttribute("member") Member member, Model model, HttpSession session,
			HttpServletRequest request) {
		Optional<Member> memberOpt = memberRepository.findByMemberPhoneNumber(member.getMemberPhoneNumber());
		if (memberOpt.isPresent() && memberOpt.get().getMemberPassword().equals(member.getMemberPassword())) {
			session.setAttribute("member", memberOpt.get());

			Member loggedInMember = memberOpt.get();
			// 更新最後登入時間
			loggedInMember.setMemberLastLoginTime(new Date());
			memberRepository.save(loggedInMember);
			session.setAttribute("member", loggedInMember);

			String previousUrl = (String) session.getAttribute("previousUrl");
			// 如果上一個頁面是註冊頁面，則導向首頁。
			if (previousUrl != null && previousUrl.contains("/member/register")) {
				return "redirect:/";
			}

			// 取得上一個頁面的url
			if (previousUrl != null && !previousUrl.contains("/member/login")) {
				session.removeAttribute("previousUrl");
				return "redirect:" + previousUrl;
			}

			return "redirect:/";
		} else {
			model.addAttribute("error", "帳號或密碼錯誤");
			return "member/login";
		}

	}

	// 會員登出
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		// 刪除session中的會員資訊
		session.removeAttribute("member");
		// 重定向到首頁
		return "redirect:/";

	}

	public MemberController() {
		// TODO Auto-generated constructor stub
	}

}
