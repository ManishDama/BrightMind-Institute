package com.example.demo13.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo13.entity.Announcements;
import com.example.demo13.entity.Enrollment;
import com.example.demo13.entity.EnrollmentAnnouncement;

public interface EnrollmentAnnouncementRepository extends JpaRepository<EnrollmentAnnouncement, Long> {
	List<Enrollment> findByEnrollment(Enrollment enroll);
	List<Announcements> findByAnnouncement(Announcements announce);
//	Optional<Enrollment>  findEnrollmentByEnrollmentId(long id);
//	Optional<Announcements>  findAnnouncementByAnnouncementId(long id);
	
	@Query(value=" select * from enrollment_announcement where enrollment_id in (select  enrollment_id from enrollment where enroll_student_email=:email)",nativeQuery = true)
	Optional<EnrollmentAnnouncement> findByEnrollment(@Param("email") String email);
	
	@Query(value=" select * from enrollment_announcement where enrollment_id in (select  enrollment_id from enrollment where enroll_student_email=:email)",nativeQuery = true)
	List<EnrollmentAnnouncement> findByEnrollments(@Param("email") String email);
	List<EnrollmentAnnouncement> findByEnrollment_EnrollStudentPhone(String phone);
	List<EnrollmentAnnouncement> findByEnrollment_EnrollmentId(long id);
	List<EnrollmentAnnouncement> findByPayment(String payment);
	List<EnrollmentAnnouncement> findByAnnouncement_AnnouncementId(Long announcementId);
}
