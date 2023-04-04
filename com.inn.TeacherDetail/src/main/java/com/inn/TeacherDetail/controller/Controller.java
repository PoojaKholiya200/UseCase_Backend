package com.inn.TeacherDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.TeacherDetailserviceImpl.TeacherServiceImpl;

import POJO.User;
import lombok.AllArgsConstructor;
@Component
@RestController
@AllArgsConstructor
@RequestMapping(path = "/user") 
public class Controller {
	@Autowired
	TeacherServiceImpl teacherServiceImpl;
	
	@GetMapping("/teacher")
	public ResponseEntity<List<User>> findByRole(){
		return ResponseEntity.ok(teacherServiceImpl.findByRole("teacher"));
	}
	
	
}
