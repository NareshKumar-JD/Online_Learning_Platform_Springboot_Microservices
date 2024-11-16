package com.micro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
}