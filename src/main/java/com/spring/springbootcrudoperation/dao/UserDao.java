package com.spring.springbootcrudoperation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.spring.springbootcrudoperation.dto.User;
import com.spring.springbootcrudoperation.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUserDao(User user) {
		return repository.save(user);
	}

	public User getUserByIdDao(int userId) {
		Optional<User> optional = repository.findById(userId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<User> saveAllUserDao(List<User> user) {
		return repository.saveAll(user);
	}

	public List<User> getAllUserDataDao() {
		return repository.findAll();
	}

	public User updateUserNameByIdDao(int userId, String userName) {

		User user = getUserByIdDao(userId);

		if (user != null) {
			user.setUserName(userName);
			repository.save(user);
			return user;
		} else {
			return null;
		}
	}

	public void deleteUserByUserIdDao(int userId) {
		User user = getUserByIdDao(userId);
		if (user != null) {
			repository.delete(user);
		}
	}
	
	public User findByUserNameDao(String userName) {
		return repository.findByUserName(userName);
	}	
	
	public List<User> sortUserByNameDao(String userName){
		
		return repository.findAll(Sort.by(Sort.Direction.ASC,userName));
	}
	
	public Page<User> displayDataByPassingPageNumberDao(int pageNumber,int pageDataSize){
		
		return repository.findAll(PageRequest.of(pageNumber, pageDataSize));
	}
	
	public User getUserByEmailDao(String userEmail) {
		
		return repository.findUserByCity(userEmail);
	}
}
