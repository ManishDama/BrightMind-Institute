package com.example.demo13.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.example.demo13.entity.AppUser;
import com.example.demo13.entity.Enrollment;
import com.example.demo13.entity.Student;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;


@Service
public class MailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	public void sendFeeReminder(Enrollment enroll,String toEmail, String studentName,String courseName,Long id) {
//		 JavaMailSenderImpl impl = (JavaMailSenderImpl) javaMailSender;
//		    System.out.println("SMTP Port: " + impl.getPort());
//		    System.out.println("Host: " + impl.getHost());
//		    System.out.println("Username: " + impl.getUsername());
//		    System.out.println("Mail Properties: " + impl.getJavaMailProperties());
		
		String paymenturl=generatePaymentLink(enroll);
        SimpleMailMessage message = new SimpleMailMessage();
//        String url="http://localhost:8080/payfee/";
        message.setTo(toEmail);
        message.setSubject("Fee Payment Reminder");
        message.setText("Dear " + studentName + ",\n\nPlease make your pending course fee payment at the earliest for the "+ courseName+".\n\nPay with the below link "+paymenturl+"\n\nThank you.\nEdu Tech");

        message.setFrom("ajaybathineedi@gmail.com");
        javaMailSender.send(message);
    }
	
	public void sendRegistrationConfirm(Enrollment enroll,String email,String studentName,String courseName) {
		
		String paymenturl=generatePaymentLink(enroll);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Regestraion Conformation");
		message.setText("Hello "+studentName+"\n\nyou have successfully enrolled into "+courseName+"."+"\n Pay course fee "+paymenturl+"\n\nThank you\nEdu Tech");
		message.setFrom("ajaybathineedi@gmail.com");
		javaMailSender.send(message);
	}
	
	private String generatePaymentLink(Enrollment enroll) {
	    try {
	        

//	    	System.out.println("ClassLoader for RazorpayClient: " + RazorpayClient.class.getClassLoader());
	    	RazorpayClient c=new RazorpayClient("rzp_test_2vS5XpmE", "NfpcuEgEdMhM0Pbb");
	        JSONObject request = new JSONObject();
	        request.put("amount", enroll.getAnnouncement().getPrice()*100); // amount in paise
	        request.put("currency", "INR");
	        request.put("description", "Course Fee Payment");

	        JSONObject customer = new JSONObject();
	        customer.put("name", enroll.getEnrollStudentName());
	        customer.put("email", enroll.getEnrollStudentEmail());
	        customer.put("contact", enroll.getEnrollStudentPhone());

	        request.put("customer", customer);
	        request.put("callback_url", "https://seeds-abandoned-memorabilia-fire.trycloudflare.com/payment-success?enrollId=" + enroll.getEnrollmentId());
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
