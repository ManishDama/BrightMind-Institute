package com.example.demo13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Enquiry;

public interface EnquiryRepo  extends JpaRepository<Enquiry, Long>{

}
