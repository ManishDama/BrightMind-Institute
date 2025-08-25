package com.example.demo13.repository;

<<<<<<< HEAD
=======
import java.time.LocalDate;
import java.time.LocalDateTime;
>>>>>>> dev2
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo13.entity.Announcements;

public interface AnnouncementRepo extends JpaRepository<Announcements, Long> {

	@Query(value = "SELECT a.* FROM announcements a WHERE a.announcement_id IN (SELECT s.announcement_id FROM student s WHERE s.app_user_id = :appUserId)", nativeQuery = true)
	List<Announcements> findAnnouncementsByAppUserId(@Param("appUserId") Long appUserId);
<<<<<<< HEAD
=======
	
	List<Announcements> findByBatchStartDateGreaterThanEqual(LocalDate today);
>>>>>>> dev2

}
