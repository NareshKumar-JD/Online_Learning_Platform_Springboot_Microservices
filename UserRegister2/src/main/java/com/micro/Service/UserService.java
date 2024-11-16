package com.micro.Service;

import java.util.List;

import com.micro.Entity.User;

public interface UserService {
	User save(User user);
	User getUserByName(String name);
	List<User> getUsers();

}
