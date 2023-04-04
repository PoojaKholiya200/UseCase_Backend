package com.inn.school.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inn.school.dao.UserDao;

@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	private com.inn.school.POJO.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		userDetail = userDao.findByEmailId(username);
		if (!Objects.isNull(userDetail))
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User not found.");

	}
	// method that return userDetail

	public com.inn.school.POJO.User getUserdetails() {
		
		return userDetail;
	}
}
