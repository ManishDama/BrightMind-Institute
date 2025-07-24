package com.example.demo13.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enquiryId;
	private String enquiryPersonName;
	private String enquiryPersonEmail;
	private String enquirySubject;
	private String enquiryMessage;
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enquiry(Long enquiryId, String enquiryPersonName, String enquiryPersonEmail, String enquirySubject,
			String enquiryMessage) {
		super();
		this.enquiryId = enquiryId;
		this.enquiryPersonName = enquiryPersonName;
		this.enquiryPersonEmail = enquiryPersonEmail;
		this.enquirySubject = enquirySubject;
		this.enquiryMessage = enquiryMessage;
	}
	public Long getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(Long enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getEnquiryPersonName() {
		return enquiryPersonName;
	}
	public void setEnquiryPersonName(String enquiryPersonName) {
		this.enquiryPersonName = enquiryPersonName;
	}
	public String getEnquiryPersonEmail() {
		return enquiryPersonEmail;
	}
	public void setEnquiryPersonEmail(String enquiryPersonEmail) {
		this.enquiryPersonEmail = enquiryPersonEmail;
	}
	public String getEnquirySubject() {
		return enquirySubject;
	}
	public void setEnquirySubject(String enquirySubject) {
		this.enquirySubject = enquirySubject;
	}
	public String getEnquiryMessage() {
		return enquiryMessage;
	}
	public void setEnquiryMessage(String enquiryMessage) {
		this.enquiryMessage = enquiryMessage;
	}
	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", enquiryPersonName=" + enquiryPersonName + ", enquiryPersonEmail="
				+ enquiryPersonEmail + ", enquirySubject=" + enquirySubject + ", nquiryMessage=" + enquiryMessage + "]";
	}
	
	
	
	
}
