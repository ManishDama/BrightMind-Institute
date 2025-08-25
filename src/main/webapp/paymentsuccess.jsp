<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Fee Receipt - Payment Success</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body class="bg-light"> <%-- Use Bootstrap's bg-light for body background --%>

<div class="container my-5 p-4 bg-white rounded shadow-sm"> <%-- Use Bootstrap utilities for spacing, background, rounded corners, and shadow --%>
    <div class="text-center pb-3 mb-4 border-bottom border-primary"> <%-- Border utilities --%>
        <h1 class="text-primary fw-bold display-6">FEE RECEIPT</h1> <%-- Bootstrap typography and weight classes --%>
        <p class="lead text-muted">Payment Confirmation for Enrollment</p>
    </div>

    <div class="row g-4 mb-4"> <%-- g-4 for consistent gutter spacing between columns --%>
        <div class="col-md-6">
            <h4 class="text-primary mb-3"><i class="fas fa-user-circle me-2"></i>Student Details</h4>
            <div class="card border-0 shadow-sm"> <%-- Card for structure, no border, light shadow --%>
                <div class="card-body p-3"> <%-- Padding inside card body --%>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Student ID:</div>
                        <div class="col-7">${studentdetails.student.studentId}</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Student Name:</div>
                        <div class="col-7">${studentdetails.student.studentName}</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Email:</div>
                        <div class="col-7">${studentdetails.student.studentEmail}</div>
                    </div>
                    <div class="row">
                        <div class="col-5 fw-bold text-muted">Phone:</div>
                        <div class="col-7">${studentdetails.student.studentPhone}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <h4 class="text-success mb-3"><i class="fas fa-receipt me-2"></i>Payment Details</h4>
            <div class="card border-0 shadow-sm">
                <div class="card-body p-3">
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Payment ID:</div>
                        <div class="col-7">${paymentdetails.paymentId}</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Status:</div>
                        <div class="col-7"><span class="badge bg-success">${paymentdetails.paymentStatus}</span></div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Payment Date:</div>
                        <div class="col-7">${paymentdetails.paymentDate}</div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-5 fw-bold text-muted">Amount:</div>
                        <div class="col-7">${studentdetails.announcement.price}</div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="text-center mt-5 mb-3">
        <p class="text-muted small">Thank you for your enrollment!</p>
        <p class="text-muted small">This is an auto-generated receipt. No signature is required.</p>
        <button class="btn btn-outline-primary mt-3" onclick="window.print()">
            <i class="fas fa-print me-2"></i>Print Receipt
        </button>
    </div>

    <div class="text-center mt-4 pt-3 border-top text-muted small">
        For queries, please contact us at support@example.com
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>