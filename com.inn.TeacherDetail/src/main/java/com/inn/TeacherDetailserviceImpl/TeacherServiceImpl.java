package com.inn.TeacherDetailserviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.TeacherDetail.Dao.TeacherDao;

import POJO.User;
import lombok.AllArgsConstructor;

@Service
public class TeacherServiceImpl {
	@Autowired
	TeacherDao teacherDao;

	public List<User> findByRole(String role){
		return teacherDao.findByRole(role);
	
	}
}

