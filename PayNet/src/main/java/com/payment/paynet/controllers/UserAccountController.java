package com.payment.paynet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.paynet.dto.LoginDto;
import com.payment.paynet.models.UserAccount;
import com.payment.paynet.services.UserAccountService;


@RestController
@RequestMapping("/user-account")
public class UserAccountController {
	@Autowired
	UserAccountService userAccountService;
	
	@PostMapping("/signup")
	public UserAccount signUp(@RequestBody UserAccount useraccount) {
		
		return userAccountService.signUp(useraccount);
		
		
	}
	
	@PostMapping("/login")
	public UserAccount login(@RequestBody LoginDto loginDto) throws Exception {
		
		return userAccountService.login(loginDto);
		
	}
	
	@GetMapping("/hello")
	public String Hello() {
		return "HELLO World!";
	}
}
