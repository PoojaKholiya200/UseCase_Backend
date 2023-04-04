package com.inn.Adminwork.restImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inn.Adminwork.POJO.AdminUser;
import com.inn.Adminwork.constants.Constants;
import com.inn.Adminwork.rest.AdminRest;
import com.inn.Adminwork.service.AdminService;
import com.inn.Adminwork.utils.AdminUtils;

@RestController
public class AdminRestImpl implements AdminRest {
	@Autowired
	AdminService adminService;
	@Autowired
	AdminUtils adminUtils;
	@Override
	public ResponseEntity<String> add(Map<String, String>requestMap) {
		try {
			return adminService.add(requestMap);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return AdminUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR );
	}
	@GetMapping
	public ResponseEntity<List<AdminUser>> getAllUsers(){
		List<AdminUser> users = adminService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
//	@PutMapping("{id}")
//	public ResponseEntity<AdminUser> updateAdminUser(@PathVariable("id") Integer adminUserId, @RequestBody AdminUser adminUser){
//		adminUser.setId(adminUserId);
//		AdminUser updateAdminUser = adminService.updateAdminUser(adminUser);
//		return new ResponseEntity<>(updateAdminUser, HttpStatus.OK);
//	}
	
	@PutMapping("/updateUser")
	public AdminUser updateAdminUser(@RequestBody AdminUser adminUser) {
		return adminService.updateAdminUser(adminUser);
		
	}
}
