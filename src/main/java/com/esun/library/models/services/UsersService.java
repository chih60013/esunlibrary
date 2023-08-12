package com.esun.library.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esun.library.models.beans.user.Users;
import com.esun.library.models.repositorys.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	
	//新增會員
	public void addUsers(Users users) {
		usersRepository.save(users);
	}
	
	
	//查詢會員
	
	public List<Users> findAllUsers(){
		List<Users> findAllUsers = usersRepository.findAll();
		return findAllUsers;
	}
	
	
	
	
	
	
}
