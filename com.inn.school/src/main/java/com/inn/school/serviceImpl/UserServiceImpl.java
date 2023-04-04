// actual business logic
package com.inn.school.serviceImpl;

import org.slf4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.inn.school.JWT.CustomerUsersDetailsService;
import com.inn.school.JWT.JwtFilter;
import com.inn.school.JWT.JwtUtil;


import com.inn.school.dao.UserDao;
import com.inn.school.service.UserService;
import com.inn.school.wrapper.UserWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j // for login purpose
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	JwtFilter jwtFilter;

//	@Override
//	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
//
//		try {
//			if (validateSignUpMap(requestMap)) {
//				User user = userDao.findByEmailId(requestMap.get("email"));
//				if (Objects.isNull(user)) {
//					userDao.save(getUserFromMap(requestMap));
//
//					return SchoolUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
//				} else {
//					return SchoolUtils.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);
//				}
//			} else {
//				return SchoolUtils.getResponseEntity(SchoolConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return SchoolUtils.getResponseEntity(SchoolConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	private boolean validateSignUpMap(Map<String, String> requestMap) {
//		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
//				&& requestMap.containsKey("password")) {
//			return true;
//		}
//		return false;
//	}
//
//	private User getUserFromMap(Map<String, String> requestMap) {
//		User user = new User();
//		user.setName(requestMap.get("name"));
//		user.setContactNumber(requestMap.get("contactNumber"));
//		user.setEmail(requestMap.get("email"));
//		user.setPassword(requestMap.get("password"));
//		user.setStatus("false");
//		user.setRole("User");
//		return user;
//	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("Inside login");
		try {
			Authentication auth = authenticationManager.authenticate(
					
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
			if (auth.isAuthenticated()) {
				log.info("Inside if of try");
					return new ResponseEntity<String>(
							"{\"token\":\""
									+ jwtUtil.generateToken(customerUsersDetailsService.getUserdetails().getEmail(),
											customerUsersDetailsService.getUserdetails().getRole())
									+ "\"}",
							HttpStatus.OK);
			}
				//if user will not approve
				else {
					return new ResponseEntity<String>("{\"message\":\"+ wait for admin approval."+"\"}", HttpStatus.BAD_REQUEST);
				}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<String>("{\"message\":\"+ Bad Credentials."+"\"}", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<UserWrapper>> getAllTeacher() {
		try {
			if(jwtFilter.isAdmin()) {
				return new ResponseEntity<>(userDao.getAllTeacher(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
