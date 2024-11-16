package com.micro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.Entity.User;
import com.micro.Repository.UserMailRepository;
import com.micro.Utility.UserMailUtility;

import java.util.Optional;

@Service
public class UserMailServiceImp implements UserMailService {

    @Autowired
    private UserMailRepository userMailRepository;

    @Autowired
    private UserMailUtility userMailUtility;
   
    @Override
    public User saveUserAndSendEmail(User user) {
        Optional<User> existingUser = userMailRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        System.out.println("Saving user: Name = " + user.getName() + ", Email = " + user.getEmail());
        userMailRepository.save(user);
      
        String subject = "Welcome to Our Service!";
        String message = String.format(
            "Dear %s,\n\nThank you for registering with us.\n\nHere are your details:\nUserId: %d\nName: %s\nPassword: %s\nEmail: %s\nPhone: %d\nAddress: %s\n\nBest regards,\nOur Team",
            user.getName(), user.getUser_id(), user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getAddress()
        );
      
        try {
            userMailUtility.sendEmail(user.getEmail(), subject, message);
        } catch (Exception e) {
            System.out.println("Error in sending email to " + user.getEmail() + ": " + e.getMessage());
            throw new RuntimeException("Email could not be sent to: " + user.getEmail());
        }
		return user;
    }
}
