package com.inn.Adminwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.Adminwork.POJO.AdminUser;

public interface AdminDao extends JpaRepository<AdminUser, Integer> {
	AdminUser findByEmailId(@Param("email") String email);

	//void updateDetail(@Param("email") String email, @Param("name") String name);
	
	
}
