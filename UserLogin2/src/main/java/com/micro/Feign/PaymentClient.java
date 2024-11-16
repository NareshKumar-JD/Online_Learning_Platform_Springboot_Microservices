package com.micro.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "PaymentService2", url = "http://localhost:6020") // Change the URL to your UserRegister2 service's URL
public interface PaymentClient {
    @GetMapping("api/payments/{studentId}")
    PaymentDTO getPaymentByStuId(@RequestParam("studentId") int studentId);
}
