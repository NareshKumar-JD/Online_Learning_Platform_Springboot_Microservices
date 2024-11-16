package com.micro.Controller;

import com.micro.DTO.PaymentDTO;
import com.micro.Entity.Payment;
import com.micro.Service.PaymentMailService;
import com.micro.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private PaymentMailService paymentMailService;
    
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Payment> getPaymentByStuId(@PathVariable int studentId) {
        Payment payment = paymentService.getPaymentByStuId(studentId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//////////////////////////////
    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        try {
             Payment savePaymentAndSendEmail = paymentMailService.savePaymentAndSendEmail(payment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savePaymentAndSendEmail);
        }
        catch (RuntimeException e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // 400 Bad Request
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // 500 Internal Server Error
      }  
    }

}
