package com.game.sgeni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.game.sgeni.entity.BnW2Record;
import com.game.sgeni.entity.UserTable;
import com.game.sgeni.service.BnW2Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class BnW2Controller {
	
	@Autowired
	private BnW2Service bnW2Service;

	@PostMapping("/bnw2/create/room")  //방을 만들었으면 해당 방으로 가야지.
    public String createRoom(Model model
    		, BnW2Record bnW2Record
    		, HttpServletRequest request
    		) {
		
//		String 유저정보 = authentication.getPrincipal().toString();
//		String 아이디 = authentication.getName();
//		System.out.println(아이디);
		
		HttpSession session = request.getSession();
		UserTable getAccount = (UserTable) session.getAttribute("user");
		getAccount.getUsername();
		
		// 방 이름, 만든 유저 아이디를 전송
		bnW2Record = bnW2Service.createRoom(bnW2Record, getAccount.getUsername());

		String uuid = bnW2Record.getRoomID(); 
		return "redirect:/bnw2/list";
//        return "redirect:/bnw2/bnw2room/"+uuid;  //만든사람이 오목방에 첫번째로 입장
    }
	
}
