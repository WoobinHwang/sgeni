package com.game.sgeni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.sgeni.entity.UserTable;
import com.game.sgeni.repository.UserTableRepository;

@Service
public class UserService {

	@Autowired
	private UserTableRepository userTableRepository;
	
	public UserTable FindAcoount(UserTable user) {
		UserTable getUser = userTableRepository.findByusername(user.getUsername());
		
		System.out.println(getUser);
		
		return getUser;
	}
	
	
	public boolean Signup(UserTable user) {
		
		
		return true;
	}
	
}
