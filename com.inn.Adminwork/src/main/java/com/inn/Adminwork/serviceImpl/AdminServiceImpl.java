package com.inn.Adminwork.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.Adminwork.POJO.AdminUser;
import com.inn.Adminwork.constants.Constants;
import com.inn.Adminwork.dao.AdminDao;
import com.inn.Adminwork.service.AdminService;
import com.inn.Adminwork.utils.AdminUtils;

@Service
public class AdminServiceImpl implements AdminService {
	//private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	AdminDao adminDao;


	@Override
	public ResponseEntity<String> add(Map<String, String> requestMap) {

		try {
			if (validateAddMap(requestMap)) {
				AdminUser user = adminDao.findByEmailId(requestMap.get("email"));
				if (Objects.isNull(user)) {
					adminDao.save(getAdminUserFromMap(requestMap));

					return AdminUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
				} else {
					return AdminUtils.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);
				}
			} else {
				return AdminUtils.getResponseEntity(Constants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return AdminUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateAddMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")&& requestMap.containsKey("role")) {
			return true;
		}
		return false;
	}

	private AdminUser getAdminUserFromMap(Map<String, String> requestMap) {
		AdminUser user = new AdminUser();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole(requestMap.get("role"));
		return user;
	}

	public AdminUser updateAdminUser(AdminUser adminUser) {
		Integer id = adminUser.getId();
		AdminUser existingAdminUser= adminDao.findById(id).get();
		existingAdminUser.setName(adminUser.getName());
		existingAdminUser.setContactNumber(adminUser.getContactNumber());
		existingAdminUser.setEmail(adminUser.getEmail());
		existingAdminUser.setPassword(adminUser.getPassword());
		existingAdminUser.setStatus("false");
		existingAdminUser.setRole(adminUser.getRole());
		return adminDao.save(existingAdminUser);
		
	}

	@Override
	public List<AdminUser> getAllUsers() {
		return adminDao.findAll();
	}	

	
}
