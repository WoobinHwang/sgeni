package com.game.sgeni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hiController {

	@GetMapping("/")
	@ResponseBody
	public String hi() {
		System.out.println("main page");
		return "hi8";
	}
}
