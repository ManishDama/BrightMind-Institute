package com.example.demo13.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
	
	Optional<AppUser> findByStudentEmail(String email);

}
