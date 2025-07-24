package com.example.demo13.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String courseName;
	private String description;
	private float price;
	private LocalDate courseStartDate;
	@Column(name="duration")
	private String duration;
	private String image;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Announcements> announcements;
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Courses(Long courseId, String courseName, String description, float price, LocalDate courseStartDate,
			String duration, String image) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.price = price;
		this.courseStartDate = courseStartDate;
		this.duration = duration;
		this.image = image;
	}


	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	
	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	

	public List<Announcements> getAnnouncements() {
		return announcements;
	}


	public void setAnnouncements(List<Announcements> announcements) {
		this.announcements = announcements;
	}


	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", price=" + price + ", courseStartDate=" + courseStartDate + "]";
	}
	
	
	
}
