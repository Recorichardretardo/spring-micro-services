package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.service.UserService;

import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user-save")
	public User saveUser(@RequestBody User user) {
		log.info("saveUser method in UserController");
		return userService.saveUser(user);
	}
	
	//ResponseTemplateVO
	
	@GetMapping("user-id/{id}")
	public ResponseTemplateVO getUserWithDepartmnent(@PathVariable("id") Long userId) {
		log.info("getUserWithDepartmnent method in UserController");
		return userService.getUserWithDepartmnent(userId);
	}
	

}
