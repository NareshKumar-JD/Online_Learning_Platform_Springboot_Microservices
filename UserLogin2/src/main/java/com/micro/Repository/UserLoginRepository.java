package com.micro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.Entity.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{

}
