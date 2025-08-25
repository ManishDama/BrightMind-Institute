package com.example.demo13.repository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> dev2

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Enrollment;

public interface EnrollRepo extends JpaRepository<Enrollment, Long> {

	List<Enrollment> findByEnrollStudentPhone(String phone);
<<<<<<< HEAD
=======
	Optional<Enrollment>  findByEnrollStudentEmail(String email);
	
>>>>>>> dev2
}
