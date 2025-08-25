package com.example.demo13.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo13.entity.Announcements;
import com.example.demo13.entity.EnrollmentAnnouncement;
import com.example.demo13.entity.Student;
import com.example.demo13.entity.StudentAnnouncement;

public interface StudentAnnouncemetRepository extends JpaRepository<StudentAnnouncement, Long> {
	List<Student> findByStudent(Student enroll);
	List<Announcements> findByAnnouncement(Announcements announce);
	Optional<StudentAnnouncement> findByStudent_StudentIdAndAnnouncement_AnnouncementId(long sid,long aid);
	List<StudentAnnouncement> findByAnnouncement_AnnouncementId(Long announcementId);

}
