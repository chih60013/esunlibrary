package com.esun.library.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esun.library.models.beans.member.Member;
import com.esun.library.models.beans.member.MemberRequest;
import com.esun.library.models.beans.member.Verification;
import com.esun.library.models.repositorys.MemberRepository;
import com.esun.library.models.services.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private Verification verification;
	

	    @Autowired
	    public MemberController(Verification verification) {
	        this.verification = verification;
	    }

//	註冊會員	
	    @CrossOrigin(origins = "http://localhost:8080")
	 @GetMapping("/member/register")
	    public String addMember(Member member, Model model) {
	        model.addAttribute("member", new Member());
	        return "member/addMember";
	    }
	    
	    @CrossOrigin(origins = "http://localhost:8080")
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
	    @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/member/memberAll")
	public String showAllMember(Model model) {
		List<Member> findAllMember = memberService.findAllMember();

		model.addAttribute("memberList", findAllMember);
		return "/member/memberAll";

	}

	// 會員登入
//	@CrossOrigin(origins = "http://localhost:8080")
//	@GetMapping("/member/login")
//	public String loginMember(Model model, HttpSession session, HttpServletRequest request) {
//		String previousUrl = request.getHeader("Referer");
//		if (previousUrl != null && !previousUrl.contains("/member/login")) {
//			session.setAttribute("previousUrl", previousUrl);
//		}
//		model.addAttribute("member", new Member());
//		return "member/login";
//
//	}

	    @CrossOrigin(origins = "http://localhost:8080")
	    @PostMapping("/member/login")
	    public ResponseEntity<String> postLoginMember(@RequestBody MemberRequest memberRequest, HttpSession session,Model model,HttpServletRequest request) {
	        // 在這裡處理登入邏輯，包括驗證用戶提供的資訊
	        // 你可以使用memberRequest來訪問Vue前端傳遞的JSON資料

	        // 檢查驗證碼是否正確
	        String actualVerification = (String) session.getAttribute("verification");
	        if (actualVerification == null || !actualVerification.equals(memberRequest.getVerification())) {
	            // 驗證碼不匹配，回傳錯誤訊息
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("驗證碼錯誤");
	        }

	        // 檢查帳號密碼
	        Optional<Member> memberOpt = memberRepository.findByMemberPhoneNumber(memberRequest.getMemberPhoneNumber());
	        if (memberOpt.isPresent() && memberOpt.get().getMemberPassword().equals(memberRequest.getMemberPassword())) {
	            // 登入成功，執行相應操作
	            // 例如設定Session，回傳成功訊息等等
	            session.setAttribute("member", memberOpt.get());
	            return ResponseEntity.ok("登入成功");
	        } else {
	            // 登入失敗，回傳錯誤訊息
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("帳號或密碼錯誤");
	        }
	    }
	    
	    
	    //原本的寫法  2023/10/10
//	    @CrossOrigin(origins = "http://localhost:8080")
//	@PostMapping("/member/login")
//	public String postLoginMember(@ModelAttribute("member") Member member,@RequestParam("verification") String userVerification, Model model, HttpSession session,
//			HttpServletRequest request) {
//		Optional<Member> memberOpt = memberRepository.findByMemberPhoneNumber(member.getMemberPhoneNumber());
//	    
//		
//		// 获取 session 中存储的验证码
//	    String actualVerification = (String) session.getAttribute("verification");
//	    System.out.println(userVerification);
//	    System.out.println(actualVerification);
//		
//		if (!userVerification.equals(actualVerification)) {
//		    // 驗證碼不匹配，返回錯誤消息
//		    model.addAttribute("error", "驗證碼錯誤");
//		    return "member/login"; // 返回登入頁面
//		}
//		if (memberOpt.isPresent() && memberOpt.get().getMemberPassword().equals(member.getMemberPassword())) {
//			session.setAttribute("member", memberOpt.get());
//
//			Member loggedInMember = memberOpt.get();
//			// 更新最後登入時間
//			loggedInMember.setMemberLastLoginTime(new Date());
//			memberRepository.save(loggedInMember);
//			session.setAttribute("member", loggedInMember);
//
//			String previousUrl = (String) session.getAttribute("previousUrl");
//			// 如果上一個頁面是註冊頁面，則導向首頁。
//			if (previousUrl != null && previousUrl.contains("/member/register")) {
//				return "redirect:/";
//			}
//
//			// 取得上一個頁面的url
//			if (previousUrl != null && !previousUrl.contains("/member/login")) {
//				session.removeAttribute("previousUrl");
//				return "redirect:" + previousUrl;
//			}
//
//			return "redirect:/";
//		} else {
//			model.addAttribute("error", "帳號或密碼錯誤");
//			return "member/login";
//		}
//
//	}

	// 會員登出
	    @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		// 刪除session中的會員資訊
		session.removeAttribute("member");
		// 重定向到首頁
		return "redirect:/";

	}

	
	//驗證器   原先能作動版本 2023/10/10  這邊其實不需要
//	    @CrossOrigin(origins = "http://localhost:8080")
//	@GetMapping("/member/generate")
//    @ResponseBody
//    public String generateCaptcha() {
//        // 使用Verification類的generateRandomCaptcha方法生成隨機驗證碼
//        String captcha = Verification.generateRandomCaptcha();
//        return captcha;
//    }
	
	@CrossOrigin
    @GetMapping("/member/generateImage")
    public void generateCaptchaImage(HttpServletResponse response, HttpSession session) throws IOException {
        // 使用Verification類的generateCaptchaImage方法生成驗證碼圖像
        String captcha = Verification.generateRandomCaptcha();   //這邊就會產生驗證碼了   用變數 captcha 承接
        BufferedImage image = Verification.generateCaptchaImage(captcha);

        // 將圖像寫入HttpServletResponse
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        
        // 存储验证码到HttpSession
        session.setAttribute("verification", captcha);
        outputStream.close();
    }
	    
//		//新驗證器   GPT
//	 // 生成驗證碼
//	    @CrossOrigin(origins = "http://localhost:8080")
//	    @PostMapping("/member/generate-captcha")
//	    @ResponseBody
//	    public String generateCaptcha() {
//	        // 使用Verification類的generateRandomCaptcha方法生成隨機驗證碼
//	        String captcha = Verification.generateRandomCaptcha();
//	        return captcha;
//	    }
//	    
//	 // 生成驗證碼圖像
//	    @CrossOrigin(origins = "http://localhost:8080")
//	    @PostMapping("/member/generate-captcha-image")
//	    public void generateCaptchaImage(HttpServletResponse response, HttpSession session) throws IOException {
//	        // 使用Verification類的generateCaptchaImage方法生成驗證碼圖像
//	        String captcha = Verification.generateRandomCaptcha(); // 這邊就會產生驗證碼了 用變數 captcha 承接
//	        BufferedImage image = Verification.generateCaptchaImage(captcha);
//
//	        // 將圖像寫入HttpServletResponse
//	        response.setContentType("image/png");
//	        OutputStream outputStream = response.getOutputStream();
//	        ImageIO.write(image, "png", outputStream);
//
//	        // 存儲驗證碼到HttpSession
//	        session.setAttribute("verification", captcha);
//	        outputStream.close();
//	    }

	    
	    
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}

}
