<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Courses</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
<section id="addcourses">
  <div class="container py-5">
    <div class="row align-items-center shadow rounded-3 bg-light p-4">
      
      <!-- Course Form -->
      <div class="col-sm-6">
        <h3 class="mb-4 text-primary fw-bold">Add New Course</h3>
        <form action="courseregister" method="post" enctype="multipart/form-data">
          
          <!-- Course Name -->
          <div class="mb-3">
            <label class="form-label">Course Name</label>
            <input type="text" name="courseName" class="form-control" placeholder="Enter new Course Name">
          </div>
          
          <!-- Course Description -->
          <div class="mb-3">
            <label class="form-label">Course Description</label>
            <textarea rows="5" cols="2" class="form-control" name="description"></textarea>
          </div>

          <!-- Price -->
          <div class="mb-3">
            <label class="form-label">Course Price</label>
            <input type="text" class="form-control" name="price" placeholder="Enter price" required>
          </div>

          <!-- Start Date -->
          <div class="mb-3">
            <label class="form-label">Course Start Date</label>
            <input type="date" class="form-control" name="courseStartDate" required>
          </div>
          
          <div class="mb-3">
            <label class="form-label">Course Duration</label>
            <input type="text" class="form-control" name="duration" required>
          </div>

			<!-- file upload -->
			<div class="mb-3">
            <label class="form-label">Course Image</label>
            <input type="file" class="form-control" name="courseImage" accept=".jpeg,.jpg,.png" required>
          </div>
          
          <!-- Buttons -->
          <div class="d-flex gap-3">
            <button type="submit" class="btn btn-success px-4">Submit</button>
            <button type="reset" class="btn btn-outline-secondary px-4">Reset</button>
          </div>
        </form>
        <div class="text-center mt-3">
      <span class="text-success">${msg1}</span><br>
    </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>