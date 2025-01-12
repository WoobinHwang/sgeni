package com.game.sgeni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.sgeni.entity.BnW2Record;
import com.game.sgeni.entity.UserTable;
import com.game.sgeni.repository.UserTableRepository;
import com.game.sgeni.service.BnW2Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private UserTableRepository userTableRepository;
	
	@Autowired
	private BnW2Service bnW2Service;
	
	@GetMapping("/")
	public String MainPage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("user"));
		System.out.println("성공");
		
		System.out.println("main page");
		List<UserTable> users = userTableRepository.findAll();
		System.out.println(users.toString());
		return "MainPage";
	}
	
	@GetMapping("/signup")
	public String SignUpPage() {
		System.out.println("sign up page");
		return "SignUpPage";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		System.out.println("login page");
		return "LoginPage";
	}
	
	@GetMapping("/bnw2/list")
	public String bnw2Page(Model model) {
		List<BnW2Record> roomList = bnW2Service.findAbleToEnterBnW2Room();
		model.addAttribute("roomList", roomList);
		
		System.out.println("흑과백2 page");
		return "BnW2roomList";
	}
	
}
