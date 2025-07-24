package com.example.demo13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo13.entity.Announcements;
import com.example.demo13.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	List<Student> findByStudentEmail(String email);
	@Query(value="SELECT a.announcement_id,a.announcing_course_title,a.description,a.course_start_date,a.image FROM student s JOIN announcements a ON s.announcement_id = a.announcement_id WHERE s.student_id = :studentid",nativeQuery = true)
	List<Announcements> findByStudentId(@Param("studentid") long id);
}
