<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
    
=======

>>>>>>> dev2
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
=======
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

>>>>>>> dev2
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Enrollment</title>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
<<<<<<< HEAD
  
=======

>>>>>>> dev2
<section class="py-5 bg-light">
  <div class="container">
    <h2 class="text-center pt-5 text-primary fw-bold mb-4">Enrollment Details</h2>

<<<<<<< HEAD

	 <!-- 🔍 Search Form -->
     <form class="row mb-4" action="/search-enrollment" method="get">
=======
	 <form class="row mb-4" action="/search-enrollment" method="get">
>>>>>>> dev2
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
<<<<<<< HEAD
   
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
=======
    <div class="text-center mb-2">
		<span class="text-danger">${message}</span>
	</div>

    <c:if test="${empty param.phone and not empty param.searchAttempted}">
        <div class="alert alert-warning text-center" role="alert">
            Please enter a mobile number to search for enrollments.
        </div>
    </c:if>

    <c:if test="${not empty param.searchAttempted and empty listOfEnrollment}">
        <div class="alert alert-info text-center" role="alert">
            No enrollments found for the provided phone number.
        </div>
    </c:if>

    <div class="row">
      <c:choose>
        <c:when test="${not empty listOfEnrollment}">
          <c:forEach var="enroll" items="${listOfEnrollment}">
            <div class="col-md-6 col-lg-4 mb-4">
              <div class="card shadow rounded-4 h-100">
                <div class="card-body">
                  <h5 class="card-title fw-bold text-success mb-3">
                    ${enroll.enrollment.enrollStudentName}
                  </h5>

                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <strong>Enrollment ID:</strong> ${enroll.enrollment.enrollmentId}
                    </li>
                    <li class="list-group-item">
                      <strong>Email :</strong> ${enroll.enrollment.enrollStudentEmail}
                    </li>
                    <li class="list-group-item">
                      <strong>Phone :</strong> ${enroll.enrollment.enrollStudentPhone}
                    </li>
                    <li class="list-group-item">
                      <strong>Payment:</strong>
                      <c:choose>
                        <c:when test="${enroll.payment eq 'unpaid'}">
                          <span class="badge bg-danger">Unpaid</span>
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
                    <%-- Corrected the typo here: removed extra dot --%>
                    <a class="btn btn-secondary" href="/send-fee-reminders?enrollId=${enroll.enrollment.enrollmentId}&announceId=${enroll.announcement.announcementId}">Send Remainder</a>
                    <a class="btn btn-secondary" href="/deleteenroll?enrollId=${enroll.enrollment.enrollmentId}&announceId=${enroll.announcement.announcementId}">Delete</a>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </c:when>
        <c:otherwise>
          <%-- This block will execute if listOfEnrollment is empty and no specific search message is shown --%>
          <div class="col-12">
            <div class="alert alert-info text-center" role="alert">
              No enrollment records found.
            </div>
          </div>
        </c:otherwise>
      </c:choose>
>>>>>>> dev2
    </div>
  </div>
</section>
</body>
</html>