package com.inn.Adminwork.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inn.Adminwork.POJO.AdminUser;

@RequestMapping(path="/user")
@CrossOrigin("*")
public interface AdminRest {
	
	@PostMapping(path="/adding")
	public ResponseEntity<String> add(@RequestBody(required=true) Map<String, String>requestMap);

}
