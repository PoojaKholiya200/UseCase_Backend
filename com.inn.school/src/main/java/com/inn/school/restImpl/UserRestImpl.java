package com.inn.school.restImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.inn.school.constants.SchoolConstant;
import com.inn.school.rest.UserRest;
import com.inn.school.service.UserService;
import com.inn.school.utils.SchoolUtils;
import com.inn.school.wrapper.UserWrapper;

@RestController
public class UserRestImpl implements UserRest{

	@Autowired
	UserService userService;
//	@Override
//	public ResponseEntity<String> signUp(Map<String, String>requestMap) {
//		try {
//			return userService.signUp(requestMap);
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		return SchoolUtils.getResponseEntity(SchoolConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR );
//	}
	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		try {
			return userService.login(requestMap);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return SchoolUtils.getResponseEntity(SchoolConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR );
	
	}
	@Override
	public ResponseEntity<List<UserWrapper>> getAllTeacher() {
		try {
			return userService.getAllTeacher();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
