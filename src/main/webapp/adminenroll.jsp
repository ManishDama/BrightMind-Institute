<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Enrollment</title>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
  
<section class="py-5 bg-light">
  <div class="container">
    <h2 class="text-center pt-5 text-primary fw-bold mb-4">Enrollment Details</h2>


	 <!-- 🔍 Search Form -->
     <form class="row mb-4" action="/search-enrollment" method="get">
      <div class="col-md-8">
        <input
          type="text"
          name="phone"
          class="form-control"
          placeholder="Enter phone number"
          value="${param.phone}"
        />
      </div>
      <div class="col-md-4">
        <button type="submit" class="btn btn-primary w-100">Search</button>
      </div>
    </form>
   
    <div class="row">
      <c:forEach var="enroll" items="${listOfEnrollment}">
        <div class="col-md-6 col-lg-4 mb-4">
          <div class="card shadow rounded-4 h-100">
            <div class="card-body">
              <h5 class="card-title fw-bold text-success mb-3">
                ${enroll.enrollStudentName}
              </h5>

              <ul class="list-group list-group-flush">
              
              	<li class="list-group-item">
                  <strong>Enrollment ID:</strong> ${enroll.enrollmentId}
                </li>
                <li class="list-group-item">
                  <strong>Email :</strong> ${enroll.enrollStudentEmail}
                </li>
                <li class="list-group-item">
                  <strong>Phone :</strong> ${enroll.enrollStudentPhone}
                </li>
                <li class="list-group-item">
  					<strong>Payment:</strong>
  						<c:choose>
    							<c:when test="${enroll.payment eq 'paid'}">
     								 <span class="badge bg-success">Paid</span>
   								 </c:when>
    							<c:otherwise>
      									<span class="badge bg-danger">Unpaid</span>
    							</c:otherwise>
  						</c:choose>
				</li>

                <li class="list-group-item">
                  <strong>Announcement ID :</strong> ${enroll.announcement.announcementId}
                </li>
                <li class="list-group-item">
                  <strong>Course Title :</strong> ${enroll.announcement.announcingCourseTitle}
                </li>
              </ul>
              <div class="mt-2 d-flex gap-3">
             	
             <a class="btn btn-secondary" href="/send-fee-reminders/${ enroll.enrollmentId}">Send Remainder</a>
              <a class="btn btn-secondary" href="/deleteenroll/${enroll.enrollmentId}">Delete</a>
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