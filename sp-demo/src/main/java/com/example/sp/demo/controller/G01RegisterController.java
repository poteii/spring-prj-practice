package com.example.sp.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sp.demo.form.G01RegisterForm;
import com.example.sp.demo.service.G01RegisterService;

@RestController
@RequestMapping("/register")
public class G01RegisterController {
	
	@Autowired
	private G01RegisterService registerService;

	
	@RequestMapping(value="/createUser",method = RequestMethod.POST)
	public void createUser(@RequestBody G01RegisterForm registerForm) {
		registerService.createUser(registerForm);
	}


}
