package com.esun.library.models.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esun.library.models.beans.user.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

	 Optional<User> findByuserPhoneNumber(String userPhoneNumber );
	 User findByToken(String token);
	 
	
	
	
}
