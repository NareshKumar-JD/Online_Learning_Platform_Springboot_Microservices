package com.micro.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.Entity.Payment;
import com.micro.Repository.PaymentMailRepository;
import com.micro.Utility.PaymentMailUtility;

@Service
public class PaymentMailServiceImp implements PaymentMailService {

    @Autowired
    private PaymentMailRepository paymentMailRepository;

    @Autowired
    private PaymentMailUtility paymentMailUtility;
   
    @Override
    public Payment savePaymentAndSendEmail(Payment payment) {
 
        Optional<Payment> existingPayment = paymentMailRepository.findByEmail(payment.getEmail());
        if (existingPayment.isPresent()) {
            throw new RuntimeException("Email already exists: " + payment.getEmail());
        }
       
        System.out.println("Saving payment: Name = " + payment.getName() + ", Email = " + payment.getEmail());
        paymentMailRepository.save(payment);
        String subject = "Payment Success!";
        String message = String.format(
            "Dear %s,\n\nThank you for registering with us.\n\nHere are your details:\nStuendtId: %s\nName: %s\nPassword: %s\nEmail: %s\nAmount: %s\n\nBest regards,\nOur Team",
            payment.getName(), 
            payment.getStudentId(), 
            payment.getName(), 
            payment.getPassword(), 
            payment.getEmail(), 
            payment.getAmount()
        );

        paymentMailUtility.sendEmail(payment.getEmail(), subject, message);
        return payment;
    }
}
