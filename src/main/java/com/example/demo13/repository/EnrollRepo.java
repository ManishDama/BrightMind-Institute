package com.example.demo13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Enrollment;

public interface EnrollRepo extends JpaRepository<Enrollment, Long> {

	List<Enrollment> findByEnrollStudentPhone(String phone);
}
