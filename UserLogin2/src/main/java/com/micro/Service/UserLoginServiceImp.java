package com.micro.Service;

import com.micro.DTO.UserLoginDTO;
import com.micro.Entity.UserLogin;
import com.micro.Feign.PaymentClient;
import com.micro.Repository.UserLoginRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImp implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Override
    public UserLogin saveUserLogin(UserLoginDTO userLoginDTO) {
        com.micro.Feign.PaymentDTO paymentDTO = paymentClient.getPaymentByStuId(userLoginDTO.getStudentId());
        if (paymentDTO != null && paymentDTO.getPassword().equals(userLoginDTO.getPassword())) {
            UserLogin userLogin = new UserLogin();
            userLogin.setLoginId(userLoginDTO.getLoginId());
            userLogin.setStudentId(userLoginDTO.getStudentId());
            userLogin.setPassword(userLoginDTO.getPassword());
      
            return userLoginRepository.save(userLogin);
        } else {
            throw new RuntimeException("Invalid credentials for user: " + userLoginDTO.getStudentId());
        }
    }

    @Override
    public List<UserLogin> getAllUserLogins() {
        return userLoginRepository.findAll();
    }

    @Override
    public UserLogin getUserLoginByStuId(int studentId) {
        return userLoginRepository.findById(studentId).orElse(null);
    }
}
