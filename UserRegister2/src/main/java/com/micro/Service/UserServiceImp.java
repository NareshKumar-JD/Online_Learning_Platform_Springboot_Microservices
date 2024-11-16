package com.micro.Service;

import com.micro.Entity.User;
import com.micro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserMailService userMailService;  

    @Override
    public User save(User user) {
        User savedUser = repo.save(user);
        try {
            userMailService.saveUserAndSendEmail(savedUser);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
            throw new RuntimeException("Error occurred while sending email.");
        }

        return savedUser;
    }

    @Override
    public User getUserByName(String name) {
        return repo.findByName(name).orElseThrow(() -> new RuntimeException("User not found with name: " + name));
    }

    @Override
    public List<User> getUsers() {
        return repo.findAll();
    }
}
