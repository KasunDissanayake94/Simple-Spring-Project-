package io.rst.springdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import io.rst.springdemo.controller.User;

@Service
public class DemoService {
	
	private List<User> usersList = new ArrayList<>(Arrays.asList(
			new User("Kasun","Dissanayake","Panadura",99,66),
			new User("Praveen","Silva","Colombo",99,66),
			new User("Deepal","Silva","Moratuwa",99,66),
			new User("Nadun","Senanayake","Kottawa",99,66)
			
			
			));
	
	public List<User> getUsers(){
		return usersList;
	}
	
	public User getUser(String name) { 
		
		return usersList.stream().filter(u -> u.getFirstname().equals(name)).findFirst().get();
	}

	public String addUser(User users) {
		usersList.add(users);
		return "Added Successfully";
		
		
	}
	public String updateUser(User user, String firstname) {
		for (int i = 0; i < usersList.size(); i++) {
			User u = usersList.get(i);
			if(u.getFirstname().equals(firstname)) {
				usersList.set(i, user);
				return "User Updated Successfully";
			}else {
				return "Problem Occured";
			}
		}
		return "Error";
	}

	public String deleteUser(String firstname) {
		usersList.removeIf(usersList -> usersList.getFirstname().equals(firstname));
		return "Deleted Successfully";
	}

}
