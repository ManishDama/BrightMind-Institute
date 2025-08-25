<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="adminmenu.jsp" %>

<section id="courses" class="py-5 bg-light min-vh-100">
  <div class="container">
    <h3 class="text-center mb-5 pt-5 fw-bold text-primary h2">Our Present Courses</h3>
    <div class="row g-4">
      <c:forEach items="${listOfCourses}" var="course">
        <div class="col-md-6 col-lg-4">
          <div class="card h-100 shadow rounded-4 border-0">
            
            <!-- Course Image -->
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
              <a href="updatecourse/${course.courseId}" class="btn btn-outline-primary btn-sm me-2">Update</a>
              <a href="deletecourse/${course.courseId}" class="btn btn-outline-danger btn-sm">Delete</a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>

</body>
</html>