//
package com.inn.school.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.school.POJO.User;
import com.inn.school.wrapper.UserWrapper;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmailId(@Param("email") String email);
	
	List<UserWrapper> getAllTeacher();
}
