<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Page</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<%@ include file="adminmenu.jsp" %>

<section class="py-5 bg-light">
  <div class="container">
    <h2 class="text-center mb-5 pt-5 text-primary fw-bold">Dashboard Overview</h2>

    <div class="row g-4">
      <!-- Total Courses -->
      <div class="col-md-4">
        <div class="card border-0 shadow-lg rounded-4 h-100">
          <div class="card-body text-center py-4">
            <div class="mb-3">
              <i class="bi bi-journal-code display-4 text-primary"></i>
            </div>
            <h5 class="card-title fw-semibold">Total Courses</h5>
            <p class="display-6 text-primary mb-0">${courseCount}</p>
          </div>
        </div>
      </div>

      <!-- Total Announcements -->
      <div class="col-md-4">
        <div class="card border-0 shadow-lg rounded-4 h-100">
          <div class="card-body text-center py-4">
            <div class="mb-3">
              <i class="bi bi-megaphone-fill display-4 text-success"></i>
            </div>
            <h5 class="card-title fw-semibold">Total Announcements</h5>
            <p class="display-6 text-success mb-0">${announcementCount}</p>
          </div>
        </div>
      </div>

      <!-- Total Enrollments -->
      <div class="col-md-4">
        <div class="card border-0 shadow-lg rounded-4 h-100">
          <div class="card-body text-center py-4">
            <div class="mb-3">
              <i class="bi bi-people-fill display-4 text-danger"></i>
            </div>
            <h5 class="card-title fw-semibold">Total Enrollments</h5>
            <p class="display-6 text-danger mb-0">${enrollmentCount}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>