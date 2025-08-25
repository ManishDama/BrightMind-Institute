package com.example.demo13.repository;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.payments;

public interface PaymentRepo extends JpaRepository<payments, Long> {
=======
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Student;
import com.example.demo13.entity.payments;

public interface PaymentRepo extends JpaRepository<payments, Long> {
	
	Optional<payments> findByPaymentId(String paymentId);
>>>>>>> dev2

}
