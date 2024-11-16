package com.micro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.DTO.UserLoginDTO;
import com.micro.Entity.UserLogin;
import com.micro.Service.UserLoginService;

@RestController
@RequestMapping("/api/userlogins")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping
    public ResponseEntity<List<UserLogin>> getAllUserLogins() {
        return ResponseEntity.ok(userLoginService.getAllUserLogins());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<UserLogin> getUserLoginByStuId(@PathVariable int studentId) {
        UserLogin userLogin = userLoginService.getUserLoginByStuId(studentId);
        if (userLogin != null) {
            return ResponseEntity.ok(userLogin);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<UserLogin> saveUserLogin(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            UserLogin userLogin = userLoginService.saveUserLogin(userLoginDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userLogin);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // 401 Unauthorized
        }
    }
}
