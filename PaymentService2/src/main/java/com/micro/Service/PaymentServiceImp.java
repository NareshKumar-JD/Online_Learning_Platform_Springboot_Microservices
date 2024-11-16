package com.micro.Service;

import com.micro.DTO.PaymentDTO;
import com.micro.DTO.UserDTO;
import com.micro.Entity.Payment;
import com.micro.Repository.PaymentRepository;
import com.micro.Feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserClient userClient;  

    @Autowired
    private PaymentMailService paymentMailService;

    @Override
    public Payment savePayment(PaymentDTO paymentDTO) {
       UserDTO userDTO = userClient.getUserByName(paymentDTO.getName());
        if (userDTO != null && userDTO.getPassword().equals(paymentDTO.getPassword())) {
            Payment payment = new Payment();
            payment.setStudentId(paymentDTO.getStudentId());
            payment.setName(paymentDTO.getName());
            payment.setPassword(paymentDTO.getPassword());
            payment.setEmail(paymentDTO.getEmail());
            payment.setAmount(paymentDTO.getAmount());
            Payment savedPayment = paymentRepository.save(payment);
          try {
                paymentMailService.savePaymentAndSendEmail(savedPayment);  // Send email after saving
            } catch (Exception e) {
                System.out.println("Error sending email: " + e.getMessage());
                throw new RuntimeException("Error occurred while sending email.");
            }

            return savedPayment;
        }

        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentByStuId(int studentId) {
        return paymentRepository.findById(studentId).orElse(null);
    }
}
