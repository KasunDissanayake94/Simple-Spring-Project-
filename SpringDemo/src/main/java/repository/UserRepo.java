package repository;

import org.springframework.data.repository.CrudRepository;

import io.rst.springdemo.controller.User;

public interface UserRepo extends CrudRepository<User, String>{

}
