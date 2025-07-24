<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edu Tech</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="menu.jsp" %>

<section id="home" class="py-5 bg-light min-vh-100 d-flex align-items-center">
  <div class="container">
    <div class="row align-items-center">
      
      <!-- Left Text Content -->
      <div class="col-lg-6 mb-4 mb-lg-0">
        <h1 class="display-4 fw-bold text-primary">Welcome to Edu Tech</h1>
        <p class="lead text-dark">
          Empower your learning journey with expert-led courses, real-world projects, and flexible schedules. Learn from anywhere, at your own pace.
        </p>
        <a href="#announcements" class="btn btn-primary btn-lg mt-3">Explore Announcements</a>
      </div>

     <div class="col-lg-6 text-center">
        <img src="https://images.pexels.com/photos/4145190/pexels-photo-4145190.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=500" 
             alt="Edu Tech Learning" class="img-fluid rounded shadow">
      </div>

    </div>
  </div>
</section>



<section id="about" class="py-5 bg-white">
  <div class="container">
    <div class="row align-items-center">
      <!-- Text Content -->
      <div class="col-md-6">
        <h2 class="fw-bold text-primary mb-4">About Edu Tech</h2>
        <p class="lead text-dark">
          Edu Tech is a modern e-learning platform dedicated to transforming education through technology.
          We offer high-quality, affordable courses designed by industry experts to help learners master in-demand skills.
        </p>
        <p>
          Whether you're a student, a working professional, or a career switcher, Edu Tech provides the right tools
          and resources to help you grow. Learn at your own pace with our flexible, self-paced courses and interactive learning experience.
        </p>
      </div>
      <div class="col-md-6 text-center">
        <img src="https://img.freepik.com/free-vector/education-concept-illustration_114360-627.jpg"
             alt="About Edu Tech" class="img-fluid rounded shadow">
      </div>
    </div>
  </div>
</section>

<section id="courses" class="py-5 bg-light min-vh-100">
  <div class="container">
    <h3 class="text-center mb-5 pt-5 fw-bold text-primary h2">Our Present Courses</h3>
    
    <div class="row g-4">
      <c:forEach items="${listOfCourses}" var="course">
        <div class="col-md-6 col-lg-4">
          <div class="card h-100 shadow rounded-4 border-0">
            
            <!-- Image Section -->
            <img src="/uploads/${course.image}" 
                 class="card-img-top rounded-top-4" 
                 alt="Course Image" 
                 style="height: 200px; object-fit: cover;">

            <div class="card-body d-flex flex-column">
              <h5 class="card-title fw-bold text-primary">${course.courseName}</h5>
              <p class="card-text text-muted small">${course.description}</p>
              <p class="card-text mb-1"><strong>Duration:</strong> ${course.duration}</p>
              <p class="card-text"><strong>Price:</strong> ₹${course.price}</p>
            </div>

            <div class="card-footer bg-white border-0 text-center">
              <a href="#contact" class="btn btn-lg btn-outline-success">Course Enquiry</a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>


<section id="announcements" class="py-5 bg-light min-vh-100">
  <div class="container">
    <h2 class="text-center mb-5 fw-bold text-primary">Our Announcements</h2>
    <div class="row g-4">
      <c:forEach items="${listOfAnnouncements}" var="announce">
        <div class="col-md-6 col-lg-4">
          <div class="card h-100 shadow-sm border-0 rounded-4">
            
            <!-- Announcement Image -->
            <img src="/uploads/${announce.image}" 
                 class="card-img-top rounded-top-4" 
                 alt="${announce.announcingCourseTitle} Image" 
                 style="height: 200px; object-fit: cover;">
            
            <div class="card-body">
              <h5 class="card-title text-primary fw-bold">${announce.announcingCourseTitle}</h5>
              <p class="card-text small text-muted">${announce.description}</p>
              <p class="card-text"><strong>Batch Start Date:</strong> ${announce.batchStartDate}</p>
              <p class="card-text"><strong>Price:</strong> ₹${announce.price}</p>
            </div>

            <div class="card-footer bg-transparent border-0 text-center">
              <a href="enrollment?announcementId=${announce.announcementId }" class="btn btn-outline-success btn-lg px-4 fw-semibold">Enroll</a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>

<section id="contact" class="py-5 bg-white">
  <div class="container">
    <h2 class="text-center text-primary fw-bold mb-4">Contact Us</h2>
    <p class="text-center mb-5">Have a question or need help? We're here to support your learning journey!</p>

    <div class="row justify-content-center">
      <div class="col-md-8">
        <form action="enquiry" method="post">
          <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" name="enquiryPersonName" id="name" placeholder="Your Name">
          </div>

          <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" name="enquiryPersonEmail" id="email" placeholder="you@example.com">
          </div>

          <div class="mb-3">
            <label for="subject" class="form-label">Subject</label>
            <input type="text" class="form-control" name="enquirySubject" id="subject" placeholder="Course Inquiry, Feedback, etc.">
          </div>

          <div class="mb-3">
            <label for="message" class="form-label">Your Message</label>
            <textarea class="form-control" id="message" name="enquiryMessage" rows="5" placeholder="Write your message here..."></textarea>
          </div >

			<div class="mb-3 text-center">
			<span class="text-success">${msg}</span>
			</div>
          <div class="text-center">
            <button type="submit" class="btn btn-primary px-4">Send Message</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>

</body>
</html>