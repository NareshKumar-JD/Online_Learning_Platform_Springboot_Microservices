package com.micro.Service;

import com.micro.Entity.User;

public interface UserMailService {
    User saveUserAndSendEmail(User user);
}
