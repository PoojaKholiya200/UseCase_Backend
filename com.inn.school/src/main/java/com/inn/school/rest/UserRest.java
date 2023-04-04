package com.inn.school.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inn.school.wrapper.UserWrapper;
//request mapping will pass the path
@RequestMapping(path = "/user")  //why we need this at the class level because in a one plus we can have multiple apis 
public interface UserRest {
	
//	@PostMapping(path="/signup")
//	public ResponseEntity<String> signUp(@RequestBody(required=true) Map<String, String>requestMap);
	@PostMapping (path="/login")
	public ResponseEntity<String> login(@RequestBody(required=true) Map<String, String> requestMap);
	
	@GetMapping(path="/getteacher")
	public ResponseEntity<List<UserWrapper>> getAllTeacher();
}
