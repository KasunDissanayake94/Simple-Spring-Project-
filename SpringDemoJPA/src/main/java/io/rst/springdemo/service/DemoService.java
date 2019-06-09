package io.rst.springdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.FirebirdDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.rst.springdemo.controller.User;
import repository.UserRepo;

@Service
public class DemoService {
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
	
	public Optional<User> getUser(String name) { 
		return userRepo.findById(name);
	}

	public String addUser(User users) {
		userRepo.save(users);
		return "Added Successfully...";
		
		
	}
	public String updateUser(User user, String firstname) {
		userRepo.save(user);
		return "Updated Successfully";
	}

	public String deleteUser(String firstname) {
		userRepo.deleteById(firstname);
		return "Deleted Successfully";
	}

}
