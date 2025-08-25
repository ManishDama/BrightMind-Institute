<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Courses</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="studentmenu.jsp" %>
<div class="container py-4 mt-5 pt-5">
    <div class="row">
        <c:forEach var="a" items="${announcements}">
            <div class="col-md-6 col-lg-4 d-flex align-items-stretch">
                <div class="card shadow-sm mb-4 w-100 border-0 rounded-4">
                    <div class="card-body bg-light rounded-4">
                        <h5 class="card-title text-primary fw-semibold">
                            ${a.announcingCourseTitle}
                        </h5>
                        <p class="card-text text-dark small">
                            ${a.description}
                        </p>
                        <p class="text-muted small mt-2">
                            <i class="bi bi-megaphone-fill"></i> Latest Update
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>