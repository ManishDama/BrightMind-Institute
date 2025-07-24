package com.example.demo13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Courses;

public interface CourseRepository  extends JpaRepository<Courses, Long>{

}
