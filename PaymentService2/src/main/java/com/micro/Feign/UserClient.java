package com.micro.Feign;

import com.micro.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserRegister2", url = "http://localhost:7021") // Change the URL to your UserRegister2 service's URL
public interface UserClient {
    @GetMapping("api/users/{name}")
    UserDTO getUserByName(@RequestParam("name") String name);
}
