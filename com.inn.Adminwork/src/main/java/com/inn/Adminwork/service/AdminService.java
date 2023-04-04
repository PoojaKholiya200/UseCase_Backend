package com.inn.Adminwork.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.inn.Adminwork.POJO.AdminUser;

public interface AdminService {
	ResponseEntity<String> add(Map<String, String> requestMap);
	
	List<AdminUser> getAllUsers();
	
	AdminUser updateAdminUser(AdminUser adminUser);
	
}
