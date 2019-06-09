package io.rst.springdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.rst.springdemo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoservice;
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return demoservice.getUsers();
	}
	
	@RequestMapping("/users/{firstname}")
	public User getUser(@PathVariable String firstname) {
		return demoservice.getUser(firstname);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public String addUser(@RequestBody User users) {
		return demoservice.addUser(users);
		
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/users/{firstname}")
	public String updateUser(@RequestBody User user, @PathVariable String firstname) {
		return demoservice.updateUser(user,firstname);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{firstname}")
	public String deleteUser(@PathVariable String firstname) {
		return demoservice.deleteUser(firstname);
	}

}
