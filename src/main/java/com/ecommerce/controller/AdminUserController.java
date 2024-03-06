package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.User;
import com.ecommerce.exception.UserException;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers(@RequestHeader("Authorization") String jwt) throws UserException{

		System.out.println("/api/users/profile");
		List<User> user=userService.findAllUsers();
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}


}
