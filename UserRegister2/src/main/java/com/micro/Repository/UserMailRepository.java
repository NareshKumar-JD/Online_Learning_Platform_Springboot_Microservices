package com.micro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.Entity.User;

import java.util.Optional;

@Repository
public interface UserMailRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); 
}
