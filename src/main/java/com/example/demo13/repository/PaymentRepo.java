package com.example.demo13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.payments;

public interface PaymentRepo extends JpaRepository<payments, Long> {

}
