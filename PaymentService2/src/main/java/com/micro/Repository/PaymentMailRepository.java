package com.micro.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.Entity.Payment;

@Repository
public interface PaymentMailRepository extends JpaRepository<Payment, Integer> {
    Optional<Payment> findByEmail(String email); 
}