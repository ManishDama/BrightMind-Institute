package com.example.demo13.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.example.demo13.entity.AppUser;
<<<<<<< HEAD
import com.example.demo13.entity.Enrollment;
import com.example.demo13.entity.Student;
=======

import com.example.demo13.entity.EnrollmentAnnouncement;

>>>>>>> dev2
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;


@Service
public class MailService {
	
	@Autowired
	JavaMailSender javaMailSender;
<<<<<<< HEAD
	public void sendFeeReminder(Enrollment enroll,String toEmail, String studentName,String courseName,Long id) {
=======
	public void sendFeeReminder(EnrollmentAnnouncement enrollAnnounce,String toEmail, String studentName,String courseName) {
>>>>>>> dev2
//		 JavaMailSenderImpl impl = (JavaMailSenderImpl) javaMailSender;
//		    System.out.println("SMTP Port: " + impl.getPort());
//		    System.out.println("Host: " + impl.getHost());
//		    System.out.println("Username: " + impl.getUsername());
//		    System.out.println("Mail Properties: " + impl.getJavaMailProperties());
		
<<<<<<< HEAD
		String paymenturl=generatePaymentLink(enroll);
=======
		String paymenturl=generatePaymentLink(enrollAnnounce);
>>>>>>> dev2
        SimpleMailMessage message = new SimpleMailMessage();
//        String url="http://localhost:8080/payfee/";
        message.setTo(toEmail);
        message.setSubject("Fee Payment Reminder");
        message.setText("Dear " + studentName + ",\n\nPlease make your pending course fee payment at the earliest for the "+ courseName+".\n\nPay with the below link "+paymenturl+"\n\nThank you.\nEdu Tech");

        message.setFrom("ajaybathineedi@gmail.com");
        javaMailSender.send(message);
    }
	
<<<<<<< HEAD
	public void sendRegistrationConfirm(Enrollment enroll,String email,String studentName,String courseName) {
		
		String paymenturl=generatePaymentLink(enroll);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Regestraion Conformation");
=======
	public void sendRegistrationConfirm(EnrollmentAnnouncement enrollAnnounce,String email,String studentName,String courseName) {
		
		String paymenturl=generatePaymentLink(enrollAnnounce);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Registration Confirmation");
>>>>>>> dev2
		message.setText("Hello "+studentName+"\n\nyou have successfully enrolled into "+courseName+"."+"\n Pay course fee "+paymenturl+"\n\nThank you\nEdu Tech");
		message.setFrom("ajaybathineedi@gmail.com");
		javaMailSender.send(message);
	}
	
<<<<<<< HEAD
	private String generatePaymentLink(Enrollment enroll) {
=======
	private String generatePaymentLink(EnrollmentAnnouncement enrollAnnounce) {
>>>>>>> dev2
	    try {
	        

//	    	System.out.println("ClassLoader for RazorpayClient: " + RazorpayClient.class.getClassLoader());
	    	RazorpayClient c=new RazorpayClient("rzp_test_2vS5XpmE", "NfpcuEgEdMhM0Pbb");
	        JSONObject request = new JSONObject();
<<<<<<< HEAD
	        request.put("amount", enroll.getAnnouncement().getPrice()*100); // amount in paise
=======
	        request.put("amount", enrollAnnounce.getAnnouncement().getPrice()*100); // amount in paise
>>>>>>> dev2
	        request.put("currency", "INR");
	        request.put("description", "Course Fee Payment");

	        JSONObject customer = new JSONObject();
<<<<<<< HEAD
	        customer.put("name", enroll.getEnrollStudentName());
	        customer.put("email", enroll.getEnrollStudentEmail());
	        customer.put("contact", enroll.getEnrollStudentPhone());

	        request.put("customer", customer);
	        request.put("callback_url", "https://seeds-abandoned-memorabilia-fire.trycloudflare.com/payment-success?enrollId=" + enroll.getEnrollmentId());
=======
	        customer.put("name", enrollAnnounce.getEnrollment().getEnrollStudentName());
	        customer.put("email", enrollAnnounce.getEnrollment().getEnrollStudentEmail());
	        customer.put("contact", enrollAnnounce.getEnrollment().getEnrollStudentPhone());

	        request.put("customer", customer);
	        request.put("callback_url", "http://localhost:8080/payment-success?enrollId=" + enrollAnnounce.getEnrollment().getEnrollmentId()+"&announceId="+enrollAnnounce.getAnnouncement().getAnnouncementId());
>>>>>>> dev2
	        request.put("callback_method", "get");

	        PaymentLink paymentLink = c.paymentLink.create(request);
	        return (String) paymentLink.get("short_url");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
		public void sendLoginCredientials(AppUser appUser) {
		
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo(appUser.getStudentEmail());
			message.setSubject("Login Credientials");
			message.setText("Hello "+appUser.getStudentName()+","+"\n\nyou have successfully got account in Edu Tech institute"+"."+"\n your Login id : "+appUser.getStudentEmail()+"\n your password :"
					+ ""+appUser.getStudentPhone()+"\n\nThank you\nEdu Tech");
			message.setFrom("ajaybathineedi@gmail.com");
			javaMailSender.send(message);
	
		}

}
