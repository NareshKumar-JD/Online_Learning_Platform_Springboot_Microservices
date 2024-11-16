package com.micro.Service;

import com.micro.DTO.PaymentDTO;
import com.micro.Entity.Payment;
import java.util.List;

public interface PaymentService {
  
    List<Payment> getAllPayments();
    Payment getPaymentByStuId(int studentId);
	Payment savePayment(PaymentDTO paymentDTO);
    
}
