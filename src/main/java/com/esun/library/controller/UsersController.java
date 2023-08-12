package com.esun.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.esun.library.models.beans.user.Users;
import com.esun.library.models.repositorys.UsersRepository;
import com.esun.library.models.services.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private UsersRepository usersRepository;
	
	
//	註冊會員
	@GetMapping("/user/register")
	public String addUser(Model model) {
		model.addAttribute("users" , new Users());
		return "users/addUserPage" ;
	}
	
	@PostMapping("/user/postUser")
	public String postUser(@ModelAttribute("users") Users users ,Model model) {
	
		usersService.addUsers(users);
		model.addAttribute("users",users);
		return "redirect:/users/showAllUsers";  //先顯示全部
		
	}
	
	
	
	//顯示全部會員資料
	@GetMapping("/user/ShowAllUsers")
	public String ShowAllUsers(Model model) {
		List<Users> findAllUsers= usersService.findAllUsers();
		model.addAttribute("findAllUsers",findAllUsers);
		return "/users/userBack";
		
	}
	
	
}
