package com.spring.springbootcrudoperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.spring.springbootcrudoperation.dao.UserDao;
import com.spring.springbootcrudoperation.dto.User;
import com.spring.springbootcrudoperation.exception.IdNotFoundException;
import com.spring.springbootcrudoperation.response.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ResponseStructure<User> responseStructure;

	public ResponseStructure<User> saveUserService(User user) {
		User user1 = userDao.saveUserDao(user);
		if (user1 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Data-Inserted!!!!");
			responseStructure.setData(user1);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Please check your code data is not inserted");
			responseStructure.setData(user1);
		}

		return responseStructure;
	}

	public User getUserByIdService(int userId) {

		return userDao.getUserByIdDao(userId);
	}

	public List<User> saveAllUserService(List<User> user) {
		return userDao.saveAllUserDao(user);
	}

	public List<User> getAllUserDataService() {

		return userDao.getAllUserDataDao();
	}

	public User updateUserNameByIdService(int userId, String userName) {
		return userDao.updateUserNameByIdDao(userId, userName);
	}

	public ResponseStructure<User> deleteUserByUserIdService(int userId) throws IdNotFoundException {

		User user = getUserByIdService(userId);

		if (user != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Data-Deleted!!!!");
			userDao.deleteUserByUserIdDao(userId);
			responseStructure.setData(user);
		} else {

			throw new IdNotFoundException("given id is not found");
		}

		return responseStructure;
	}

	public User findByUserNameServcie(String userName) {
		return userDao.findByUserNameDao(userName);
	}

	public List<User> sortUserByNameService(String userName) {
		return userDao.sortUserByNameDao(userName);
	}

	public Page<User> displayDataByPassingPageNumberService(int pageNumber, int pageDataSize) {

		return userDao.displayDataByPassingPageNumberDao(pageNumber, pageDataSize);
	}
	
	public User getUserByEmailService(String userEmail) {
		return userDao.getUserByEmailDao(userEmail);
	}
}
