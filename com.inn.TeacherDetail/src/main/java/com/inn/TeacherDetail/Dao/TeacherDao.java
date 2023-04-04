package com.inn.TeacherDetail.Dao;

import java.util.List;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<User, Integer>{
	List<POJO.User> findByRole(String role);

}
