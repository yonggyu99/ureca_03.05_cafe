package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@GetMapping("insertMember")
	
	public String insertMember() {
		return "ok";
	}
}
