package com.shop.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
//@CrossOrigin("http://127.0.0.1:8080/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	
	@PostMapping("login")
	
	public Map<String, String> login(@RequestBody Member m, HttpServletRequest request) {
		
		System.out.println(m);
		
		Map<String, String> responseData = new HashMap();
		
		try {
			m = memberService.login(m);
			
			if(m!=null) {	//로그인이 된 상황
				HttpSession session = request.getSession();
				System.out.println(session.getId());
				session.setAttribute("member", m);
				responseData.put("msg", "ok");
			}
		
			else {		//로그인이 실패 된 상황
				responseData.put("msg", "다시 로그인 해주세요");
			}
			
		} catch (Exception e) {	//로그인을 처리하다가 에러가 난 상황
			responseData.put("msg", "다시 로그인 해주세요");
			e.printStackTrace();
		}
		return responseData;
	}
	
	
	
	@PostMapping("insertMember")
	
	public Map<String, String> insertMember(@RequestBody Member m) {
		
		Map<String, String> responseData = new HashMap();
		try {
			memberService.insertMember(m);
			responseData.put("msg", "ok");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			responseData.put("msg", e.getMessage());
		}
		
		return responseData;
	}
}
