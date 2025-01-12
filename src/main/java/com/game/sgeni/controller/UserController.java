package com.game.sgeni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.sgeni.entity.UserTable;
import com.game.sgeni.repository.UserTableRepository;
import com.game.sgeni.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserTableRepository userTableRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String signup(UserTable user) {		
		System.out.println(user);
		userTableRepository.save(user);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, UserTable user) {
		HttpSession session = request.getSession();
		
		UserTable getAccount = userTableRepository.findByusername(user.getUsername());
		
		session.setAttribute("user", getAccount);

		return "redirect:/";
	}
	
	@PostMapping("/find/account")
	@ResponseBody
	public UserTable findAccount(UserTable user) {
		System.out.println(user.toString());
		UserTable account = userService.FindAcoount(user);
		return account;
	}
	
}
