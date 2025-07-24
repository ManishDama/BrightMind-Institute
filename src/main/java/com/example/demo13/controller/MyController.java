package com.example.demo13.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo13.entity.Announcements;
import com.example.demo13.entity.AppUser;
import com.example.demo13.entity.Courses;
import com.example.demo13.entity.Employee;
import com.example.demo13.entity.Enquiry;
import com.example.demo13.entity.Enrollment;
import com.example.demo13.entity.Register;
import com.example.demo13.entity.Student;
import com.example.demo13.entity.payments;
import com.example.demo13.repository.AnnouncementRepo;
import com.example.demo13.repository.AppUserRepo;
import com.example.demo13.repository.CourseRepository;
import com.example.demo13.repository.EmployeeRepo;
import com.example.demo13.repository.EnquiryRepo;
import com.example.demo13.repository.EnrollRepo;
import com.example.demo13.repository.PaymentRepo;
import com.example.demo13.repository.Registerrepo;
import com.example.demo13.repository.StudentRepo;
import com.example.demo13.service.MailService;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class MyController {
	
	@Autowired
	Registerrepo registerRepo;
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	AnnouncementRepo announcementRepo;
	
	@Autowired
	EnrollRepo enrollRepo;
	
	@Autowired
	EnquiryRepo enquiryRepo;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	PaymentRepo paymentRepo;
	
	@Autowired
	AppUserRepo appUserRepo;
	
	@RequestMapping("/")
	public String login(Model model) {
		List<Courses> courses=courseRepo.findAll(Sort.by("courseId"));
		List<Announcements> announcement=announcementRepo.findAll(Sort.by("announcementId"));
		model.addAttribute("listOfCourses", courses);
		model.addAttribute("listOfAnnouncements", announcement);
		return "index.jsp";
	}
	
	
	@RequestMapping("/loginpage")
	public String loginPage() {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String loginCheck(@RequestParam String email,@RequestParam String pwd,HttpSession session,RedirectAttributes attribute) {
			Optional<Employee> opt=empRepo.findByEmail(email);
			Optional<AppUser> optUser=appUserRepo.findByStudentEmail(email);
			if(opt.isPresent()) {
				if(opt.get().getDesig().equalsIgnoreCase("Admin") && opt.get().getPassword().equals(pwd)) {
					session.setAttribute("admin", opt.get());
					return "redirect:/adminhome";
				}
				else {
					attribute.addFlashAttribute("msg", "Invalid Password");
					return "redirect:/loginpage";
				}
			}
			else if(optUser.isPresent()) {
				if(optUser.get().getStudentPassword().equalsIgnoreCase(pwd)) {
					session.setAttribute("students", optUser.get());
					
					return "redirect:/studenthome";
				}
				else {
					attribute.addFlashAttribute("msg", "Invalid Password");
					return "redirect:/loginpage";
				}
			}
			else {
			attribute.addFlashAttribute("msg", "Invalid Credientials");
			return "redirect:/loginpage";
			}
	}
	
	
	@RequestMapping("/adminhome")
	public String adminhome(HttpSession session,Model model) {
		if(session.getAttribute("admin")!=null) {
			
			long courseCount=courseRepo.count();
			long announcementCount=announcementRepo.count();
			long enrollmentCount=enrollRepo.count();
			model.addAttribute("courseCount", courseCount);
			model.addAttribute("announcementCount", announcementCount);
			model.addAttribute("enrollmentCount", enrollmentCount);
			return "adminhome.jsp";
		}
		return "redirect:/loginpage";
	}
	
	@RequestMapping("/studenthome")
	public String studentHome() {
		return "studenthome.jsp";
	}
	

	@GetMapping("/mycourses")
	public String showMyCourses(HttpSession session, Model model) {
	    AppUser user = (AppUser) session.getAttribute("students");

	    List<Announcements> announcements = announcementRepo.findAnnouncementsByAppUserId(user.getAppUserId());

	    model.addAttribute("announcements", announcements);

	    return "studentcourses.jsp"; 
	}

	
	@RequestMapping("/logout")
	public String logout(HttpSession session,RedirectAttributes attributes) {
		session.invalidate();
		attributes.addFlashAttribute("msg2", "Logged out successfully");
		return "redirect:/loginpage";
	}
	
	
	@PostMapping("/courseregister")
	public String courseRegister(@ModelAttribute Courses course,
	                             RedirectAttributes attribute,
	                             @RequestParam("courseImage") MultipartFile inputFile) {

	    // Create upload directory if not exists
	    String uploadDir = "uploads";
	    File folder = new File(uploadDir);
	    if (!folder.exists()) {
	        folder.mkdirs(); // Creates uploads/ folder
	    }

	    try {
	        String filename = inputFile.getOriginalFilename().replaceAll("\\s+", "_"); // Sanitize filename
//	        String extension =filename.substring(filename.lastIndexOf("."));
	        String finalFileName=System.currentTimeMillis()+"_"+filename;
	        Path path = Paths.get(uploadDir + File.separator + finalFileName);
	        Files.write(path, inputFile.getBytes());
	        course.setImage(finalFileName); // Save filename in DB
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    courseRepo.save(course);
	    attribute.addFlashAttribute("msg1", "Course added successfully");
	    return "redirect:/addcourses";
	}

	
	
	@PostMapping("/announcementregister")
	public String announcementRegister(Announcements announce,@RequestParam("courseId") Long courseId, RedirectAttributes attribute,@RequestParam("announcementImage") MultipartFile inputFile) {
		
		try {
			String orgFileName=inputFile.getOriginalFilename().replace("\\s+", "_");
			String newFileName=System.currentTimeMillis()+"_"+orgFileName;
			Path path=Paths.get("uploads"+File.separator+newFileName);
			Files.write(path,inputFile.getBytes());
			announce.setImage(newFileName);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Optional<Courses> opt=courseRepo.findById(courseId);
		if(opt.isPresent()) {
			Courses course=opt.get();
			announce.setCourse(course);
			announce.setAnnouncingCourseTitle(course.getCourseName());
			announcementRepo.save(announce);
			attribute.addFlashAttribute("msg2","Announcement added successfully");
			return "redirect:/addannouncements";
		}
		else {
			attribute.addFlashAttribute("msg2","No such course presented");
			return "redirect:/addannouncements";
		}
		
	}
	
	
	@RequestMapping("/deletecourse/{Id}")
	public String deleteCourse(@PathVariable Long Id) {
		courseRepo.deleteById(Id);
		return "redirect:/courses";
	}
	
	@RequestMapping("/deleteannouncement/{Id}")
	public String deleteAnnouncement(@PathVariable Long Id) {
		System.out.println(Id);
		announcementRepo.deleteById(Id);
		return "redirect:/announcements";
	}
	
	@RequestMapping("updatecourse/{Id}")
	public String updateCourse(@PathVariable Long Id,Model model) {
		Optional<Courses> opt=courseRepo.findById(Id);
		if(opt.isPresent()) {
			Courses course=opt.get();
			model.addAttribute("updatecourse", course);
			return "/updatecourse.jsp";
		}
		else {
			return "redirect:/adminhome";
		}
	}
	
	@RequestMapping("/updatedcourse")
	public String updatedCourse() {
		return "updatecourse.jsp";
	}
	
	@PostMapping("/updatecourses")
	public String updatedCourse(Courses course,@RequestParam("oldImage") String oldFile,
			@RequestParam("courseImageFile") MultipartFile newFile,RedirectAttributes attribute) 
	{
		try {
	        if (!newFile.isEmpty()) {
	            String fileName = newFile.getOriginalFilename();
	            String finalName=System.currentTimeMillis()+"_"+fileName;
	            Path path = Paths.get("uploads/" + finalName);
	            Files.write(path, newFile.getBytes());
	            course.setImage(finalName);
	        } else {
	            course.setImage(oldFile); // keep the old image
	        }
	        
	        Optional<Courses> opt=courseRepo.findById(course.getCourseId());
	        if(opt.isPresent()) {
	        	Courses courses=opt.get();
	        	courses.setCourseId(course.getCourseId());
	        	courses.setCourseName(course.getCourseName());
	        	courses.setCourseStartDate(course.getCourseStartDate());
	        	courses.setDescription(course.getDescription());
	        	courses.setDuration(course.getDuration());
	        	courses.setPrice(course.getPrice());
	        	courses.setImage(course.getImage());
	        	courseRepo.save(courses);
	        }	
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		attribute.addFlashAttribute("msg", "course Details Updated Successfully");
	    return "redirect:/updatedcourse";
	}
	
	
	@RequestMapping("updateannouncement/{Id}")
	public String updateAnnouncmet(@PathVariable Long Id,Model model) {
		Optional<Announcements> opt=announcementRepo.findById(Id);
		if(opt.isPresent()) {
			Announcements announce=opt.get();
			model.addAttribute("updateannouncement", announce);
			return "/updateannouncement.jsp";
		}
		else {
			return "redirect:/adminhome";
		}
	}
	
	@RequestMapping("/updatedannouncement")
	public String updatedAnnouncement() {
		return "updateannouncement.jsp";
	}
	
	@PostMapping("/updateannouncements")
	public String updatedAnnouncement(Announcements announce,@RequestParam("oldImage") String oldFile,
			@RequestParam("courseImageFile") MultipartFile newFile,RedirectAttributes attribute) 
	{
		try {
	        if (!newFile.isEmpty()) {
	            String fileName = newFile.getOriginalFilename();
	            String finalName=System.currentTimeMillis()+"_"+fileName;
	            Path path = Paths.get("uploads/" + finalName);
	            Files.write(path, newFile.getBytes());
	            announce.setImage(finalName);
	        } else {
	            announce.setImage(oldFile); // keep the old image
	        }
	        
	        Optional<Announcements> opt=announcementRepo.findById(announce.getAnnouncementId());
	        if(opt.isPresent()) {
	        	Announcements announcement=opt.get();
	        	announcement.setAnnouncementId(announce.getAnnouncementId());
	        	announcement.setAnnouncingCourseTitle(announce.getAnnouncingCourseTitle());
	        	announcement.setBatchStartDate(announce.getBatchStartDate());
	        	announcement.setDescription(announce.getDescription());
	        	announcement.setPrice(announce.getPrice());
	        	announcement.setImage(announce.getImage());
	        	announcementRepo.save(announcement);
	        	System.out.println(announcement.getAnnouncementId());
	        	System.out.println(announcement.getAnnouncingCourseTitle());
	        	System.out.println(announcement.getDescription());
	        	System.out.println(announcement.getImage());
	        	System.out.println(announcement.getPrice());
	        	System.out.println(announcement.getBatchStartDate());
	        	System.out.println(announcement.getCourse());
//	        	System.out.println(announcement.getPrice());
	        }	
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		attribute.addFlashAttribute("msg", "Announcement Details Updated Successfully");
	    return "redirect:/updatedannouncement";	
	   }
	
	
	@RequestMapping("/enrollment")
	public String enrollStudent(@RequestParam("announcementId") String announcementId,Model model) {
			Long Id=Long.parseLong(announcementId);
		    Optional<Announcements> opt=announcementRepo.findById(Id);
		    if(opt.isPresent()) {
		    	model.addAttribute("announceId", Id);
		    	return "enroll.jsp";
		    }
		    else {
		    	return "reditect:/";
		    }
	}
	
	@RequestMapping("/enroll")
	public String enroll() {
		return "/enroll.jsp";
	}
	
	@PostMapping("/enrollstudent")
	public String enrollStudent(Enrollment enroll,@RequestParam("announcementId") Long Id, RedirectAttributes attribute) {
		
		Optional<Announcements> opt=announcementRepo.findById(Id);
		if(opt.isPresent()) {
			Announcements announce=opt.get();
			enroll.setAnnouncement(announce);
			enrollRepo.save(enroll);
			attribute.addFlashAttribute("msg","Enrollment Success check registered email...");
			mailService.sendRegistrationConfirm(enroll,enroll.getEnrollStudentEmail(), enroll.getEnrollStudentName(), enroll.getAnnouncement().getAnnouncingCourseTitle());
			return "redirect:/enroll";	
		}
		attribute.addFlashAttribute("msg","Enrollment Failed");
		return "redirect:/enroll";	
	}
	
	@PostMapping("/enquiry")
	public String enquiry(Enquiry enquiry,RedirectAttributes attribute) {
		enquiryRepo.save(enquiry);
		attribute.addFlashAttribute("msg", "Enquiry Details send...");
		return "redirect:/";
	}
	
	@RequestMapping("/courses")
	public String courses(Model model) {
		List<Courses> course=courseRepo.findAll(Sort.by("courseId"));
		model.addAttribute("listOfCourses", course);
		return "courses.jsp";
	}
	
	@RequestMapping("/addcourses")
	public String addCourses(Model model) {
		List<Courses> course=courseRepo.findAll(Sort.by("courseId"));
		model.addAttribute("listOfCourses", course);
		return "addcourses.jsp";
	}
	
	@RequestMapping("/announcements")
	public String announcements(Model model) {
		
		List<Announcements> announce=announcementRepo.findAll(Sort.by("announcementId"));
		model.addAttribute("listOfAnnouncements", announce);
		return "announcement.jsp";
	}
	
	@RequestMapping("/addannouncements")
	public String addAnnouncements(Model model) {
		List<Courses> course=courseRepo.findAll(Sort.by("courseId"));
		model.addAttribute("listOfCourses", course);
		List<Announcements> announce=announcementRepo.findAll(Sort.by("announcementId"));
		model.addAttribute("listOfAnnouncements", announce);
		return "addannouncement.jsp";
	}
	
	@RequestMapping("/enrollments")
	public String enrollments(Model model) {
		List<Enrollment> enroll=enrollRepo.findAll(Sort.by(Direction.DESC,"enrollmentId"));
		model.addAttribute("listOfEnrollment", enroll);
		return "adminenroll.jsp";
	}
	
	@RequestMapping("/deleteenroll/{Id}")
	public String deleteEnroll(@PathVariable Long Id) {
		enrollRepo.deleteById(Id);
		return "redirect:/enrollments";
	}
	

	
	@GetMapping("/send-fee-reminders/{Id}")
	public String sendFeeReminders(@PathVariable long Id,RedirectAttributes redirectAttributes) {
	    Optional<Enrollment> opt = enrollRepo.findById(Id);
	    if(opt.isPresent()) {
	        mailService.sendFeeReminder(opt.get(),opt.get().getEnrollStudentEmail(), opt.get().getEnrollStudentName(),opt.get().getAnnouncement().getAnnouncingCourseTitle(),opt.get().getEnrollmentId());
	    	redirectAttributes.addFlashAttribute("msg", "Fee reminders sent to all enrolled students!");
	    	return "redirect:/enrollments";
	    }
		else {
			return "redirect:/enrollments";
	}
	}
	
	

	
	@RequestMapping("/payment-success")
	public String payment(@RequestParam("enrollId") Long enrollId,@RequestParam(value = "razorpay_payment_id", required = false) String paymentId ) {
		
		if(paymentId==null) {
			return "error";
		}
		
		else {
		try {
			RazorpayClient client=new RazorpayClient("rzp_test_2vS5Xez","NfpcuEgwrr0vb");
			Payment link=client.payments.fetch(paymentId);
			String status=link.get("status").toString();
			
			if("captured".equalsIgnoreCase(status)) {
				
				Optional<Enrollment> opt=enrollRepo.findById(enrollId);
				if(opt.isPresent()) {
					Enrollment enroll=opt.get();
					enroll.setPayment("paid");
					enrollRepo.save(enroll);
					
					AppUser appUser=new AppUser();
					Optional<AppUser> optApp=appUserRepo.findByStudentEmail(enroll.getEnrollStudentEmail());
					if(optApp.isEmpty()) {
						appUser.setStudentEmail(enroll.getEnrollStudentEmail());
						appUser.setStudentName(enroll.getEnrollStudentName());
						appUser.setStudentPhone(enroll.getEnrollStudentPhone());
						appUser.setStudentPassword(enroll.getEnrollStudentPhone());
						appUserRepo.save(appUser);
						mailService.sendLoginCredientials(appUser);	
					}
					else {
						appUser=optApp.get();
					}
					payments payment=new payments();
					payment.setPaymentId(paymentId);
					payment.setPaymentStatus("paid");
					payment.setPaymentDate(LocalDateTime.now());
					paymentRepo.save(payment);
						
					Student student=new Student();
					student.setStudentName(enroll.getEnrollStudentName());
					student.setStudentEmail(enroll.getEnrollStudentEmail());
					student.setStudentPhone(enroll.getEnrollStudentPhone());
					student.setAnnouncement(enroll.getAnnouncement());
					student.setPayment(payment);
					student.setAppUser(appUser);
					student.setEnrolledTime(LocalDateTime.now());
					studentRepo.save(student);
					return "redirect:/paymentsuccess";
				}
				
			}
			else {
				return "redirect:/paymentfailed";
			}
			
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "something went wrong..";
	}
	}
	
	@RequestMapping("/paymentsuccess")
	public String paymentSuccess() {
		return "paymentsuccess.jsp";
	}
	
	@RequestMapping("/paymentfailed")
	public String paymentFailed() {
		return "paymentfailed.jsp";
	}
	
	
	@GetMapping("/search-enrollment")
		public String searchEnrollment(@RequestParam("phone") String phone,Model model) {
		
		List<Enrollment> enrollments;

	    if (phone != null ) {
	        enrollments = enrollRepo.findByEnrollStudentPhone(phone);
	    } else {
	        enrollments = enrollRepo.findAll();
	    }

	    model.addAttribute("listOfEnrollment", enrollments);
	    return "adminenroll.jsp"; 
			
		}
	@RequestMapping("/enquiry")
	public String enquiry(Model model) {
		List<Enquiry> enquiry=enquiryRepo.findAll();
		model.addAttribute("listOfEnquiry", enquiry);
		return "adminenquiry.jsp";
	}
	
}


//@RequestMapping("/payfee/{Id}")
//public String payfee(@PathVariable long Id) {
//	Optional<Enrollment> opt=enrollRepo.findById(Id);
//	if(opt.isPresent()) {
//		Enrollment enroll=opt.get();
//		enroll.setPayment("paid");
//		enrollRepo.save(enroll);
//		return "/paymentsuccess.jsp";
//	}
//	else {
//		return "/paymentfailed.jsp";
//	}
//}
//	@RequestMapping("/registerpage")
//	public String index() {
//		
//		
//		return "index.jsp";
//	}
	
	
	
	
//	
//	@PostMapping("/register")
//	public String register(Register register,RedirectAttributes attribute) {
//		Optional<Register> opt=repo.findById(register.getEmail());
//		if(opt.isPresent()) {
//			attribute.addFlashAttribute("msg", "Email already Exists");
//			return "redirect:/registerpage";
//		}
//		repo.save(register);
//		attribute.addFlashAttribute("msg1", "Registration Success Login Here");
//		return "redirect:/loginpage";
//	}
//	

//	
//	@RequestMapping("/login")
//	public String login(@RequestParam String email,@RequestParam String pwd,RedirectAttributes attribute,HttpSession session) 
//	{
//		try 
//		{
//		Register reg=repo.findById(email).orElse(null);
////		Register reg=repo.getReferenceById(email);
////		System.err.println(reg);
//		if(reg!=null)
//		{
//			if(reg.getPwd().equalsIgnoreCase(pwd)) 
//			{
//				if(reg.getDesig().equalsIgnoreCase("user"))
//				{
//					session.setAttribute("user", reg);
//					session.setAttribute("useremail", reg.getEmail());
//					return "redirect:/userhome";
//				}
//				else
//				{
//					session.setAttribute("admin", reg);
//					session.setAttribute("adminemail", reg.getEmail());
//					return "redirect:/adminhome";
//				}
//			}
//			else
//			{
//				attribute.addFlashAttribute("msg","Invalid Password");
//				return "redirect:/loginpage";
//			}
//		}else 
//		{
//		attribute.addFlashAttribute("msg","Invalid credientials");
//		return "redirect:/loginpage";
//		}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			attribute.addFlashAttribute("msg","something went wrong");
//			return "redirect:/loginpage";
//		}
//	}
//	
//	@RequestMapping("/userhome")
//	public String userhome(HttpSession session,Model model) {
//		if(session.getAttribute("user")!=null) {
//			String email=(String)session.getAttribute("useremail");
//			model.addAttribute("usermail", email);
//			return "userhome.jsp";
//		}
//		return "redirect:/loginpage";
//	}
//	

//	

//	
//	@RequestMapping("/allusers")
//	public String allUsers(Model model) {
//		List<Register> users=repo.findAll();
//		System.out.println(users);
//		model.addAttribute("users", users);
//		return "allusers.jsp";	
//	}
//	
//	@RequestMapping("/update/{email}")
//	public String update(@PathVariable String email,Model model) {
//		Optional<Register> opt=repo.findById(email);
//		if(opt.isPresent()) {
//			Register r=opt.get();
//			model.addAttribute("update", r);
//			return "update.jsp";
//		}
//		return "/allusers";
//	}
//	
//	@PostMapping("/update/update1")
//	public String update(Register register,RedirectAttributes attribute) {
//		Optional<Register> opt=repo.findById(register.getEmail());
//		if(opt.isPresent()) {
//			repo.save(register);
//			return "redirect:/allusers";
//		}
//		else {
//			attribute.addFlashAttribute("msg", "mail id doesn't exists please register");
//			return "redirect:/registerpage";
//		}
//	}
//	
//	@RequestMapping("/delete/{email}")
//	public String delete(@PathVariable String email) {
//		repo.deleteById(email);
//		return "/allusers";
//		
//	}	
//	
//}
