package com.micro.Service;

import java.util.List;

import com.micro.DTO.UserLoginDTO;
import com.micro.Entity.UserLogin;

public interface UserLoginService {
	 
	    List<UserLogin> getAllUserLogins();
	    UserLogin getUserLoginByStuId(int studentId);
		UserLogin saveUserLogin(UserLoginDTO userLoginDTO);
	    
	}
