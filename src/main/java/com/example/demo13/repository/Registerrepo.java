package com.example.demo13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Register;

public interface Registerrepo extends JpaRepository<Register, String> {

}
