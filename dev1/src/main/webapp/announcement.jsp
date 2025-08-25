<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Announcements</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
<section id="announcements" class="py-5 bg-light min-vh-100">
  <div class="container">
    <h2 class="text-center mb-5 pt-5 fw-bold text-primary">Our Announcements</h2>
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

			
            <div class="card-footer bg-white border-0">
    				<div class="d-grid gap-2 d-md-flex justify-content-md-center">
				        <a href="updateannouncement/${announce.announcementId}"
				           class="btn btn-primary btn-sm me-2 mb-2 mb-md-0 d-flex align-items-center justify-content-center">
				            Update
				        </a>
				        
				        <a href="students-by-announcement/${announce.announcementId}"
				           class="btn btn-info btn-sm me-2 mb-2 mb-md-0 d-flex align-items-center justify-content-center">
				            List Of Students
				        </a>
				        
				        <a href="enrollments-by-announcement/${announce.announcementId}"
				           class="btn btn-success btn-sm d-flex align-items-center justify-content-center">
				            List Of Enrollments
				        </a>
    				</div>
				</div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>
</body>
</html>