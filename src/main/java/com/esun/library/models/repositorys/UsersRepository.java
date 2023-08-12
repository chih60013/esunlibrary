package com.esun.library.models.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.user.Users;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Integer> {

//	 Optional<User> findByuserPhoneNumber(String userPhoneNumber );
//	 User findByToken(String token);
	 
	
	
	
}
