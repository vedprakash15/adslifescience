package com.august.v1.controller.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.august.v1.domain.User;
import com.august.v1.domain.response.dto.UserSignUpResponse;
import com.august.v1.service.SignUpService;

@RestController
@RequestMapping("/user/")
public class SignUpController {
	
	@Autowired
	private SignUpService signupservice;
	
	/*@Autowired
	private UserSignUpResponse signupresp;*/
	
	@PostMapping(path="signup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserSignUpResponse> signUp(@RequestBody User user){
		System.out.println("signup api called");
		System.out.println(user.toString());

		//UserSignUpResponse resp = new UserSignUpResponse();
		 signupservice.signup(user);
		
		return new ResponseEntity<UserSignUpResponse>(HttpStatus.OK);
	}
}
