<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enrollments for Announcement</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" xintegrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Google Fonts - Inter (Optional, but good for consistent typography) -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Note: For a true "Bootstrap only" approach, you might skip custom fonts,
         but including Inter via CDN is a common practice and doesn't involve custom CSS. -->
    <style>
        /* Optional: If you want Inter font applied globally, otherwise Bootstrap's default font will be used */
        body {
            font-family: 'Inter', sans-serif;
        }
    </style>
</head>
<body class="bg-light d-flex justify-content-center align-items-start min-vh-100 py-5 px-3">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-8">
                <div class="card shadow-lg rounded-4 p-4 p-md-5">
                    <h2 class="text-center text-dark mb-4 pb-3 border-bottom">Enrollments for Announcement</h2>

                    <div class="mb-4">
                        <p class="lead fw-bold text-primary">Course: <c:out value="${announcement.announcingCourseTitle}"/></p>
                        <p class="text-muted"><strong>Description:</strong> <c:out value="${announcement.description}"/></p>
                        <p class="text-muted"><strong>Batch Start Date:</strong> <c:out value="${announcement.batchStartDate}"/></p>
                    </div>

                    <c:if test="${not empty listOfEnrollments}">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover table-bordered border-primary">
                                <thead class="bg-primary text-white">
                                    <tr>
                                        <th scope="col">Enrollment ID</th>
                                        <th scope="col">Student Name</th>
                                        <th scope="col">Student Email</th>
                                        <th scope="col">Student Phone</th>
                                        <th scope="col">Enrolled At</th>
                                        <th scope="col">Payment Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="enrollmentAnn" items="${listOfEnrollments}">
                                        <tr>
                                            <td><c:out value="${enrollmentAnn.id}"/></td>
                                            <td><c:out value="${enrollmentAnn.enrollment.enrollStudentName}"/></td>
                                            <td><c:out value="${enrollmentAnn.enrollment.enrollStudentEmail}"/></td>
                                            <td><c:out value="${enrollmentAnn.enrollment.enrollStudentPhone}"/></td>
                                            <td><c:out value="${enrollmentAnn.payment}"/></td>
                                             <td><a class="btn btn-secondary" href="/send-fee-reminders?enrollId=${enrollmentAnn.enrollment.enrollmentId}&announceId=${enrollmentAnn.announcement.announcementId}">Send Remainder</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <c:if test="${empty listOfEnrollments}">
                        <div class="alert alert-info text-center py-3 rounded-3" role="alert">
                            <p class="mb-0">No enrollments found for this announcement.</p>
                        </div>
                    </c:if>
                    <div class="text-center mt-4">
                        <a href="/announcements" class="btn btn-secondary btn-lg rounded-pill px-4">Back to Announcements</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" xintegrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
