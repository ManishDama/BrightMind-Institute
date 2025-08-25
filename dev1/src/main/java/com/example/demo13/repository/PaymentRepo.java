package com.example.demo13.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Student;
import com.example.demo13.entity.payments;

public interface PaymentRepo extends JpaRepository<payments, Long> {
	
	Optional<payments> findByPaymentId(String paymentId);

}
