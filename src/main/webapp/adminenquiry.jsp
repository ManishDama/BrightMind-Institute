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

<title>Enquires</title>
</head>
<body>
<%@ include file="adminmenu.jsp" %>
<section class="py-5 bg-light">
  <div class="container">
    <h2 class="text-center text-primary fw-bold pt-5 mb-5">Enquiries</h2>

    <div class="row">
      <c:forEach var="enquiry" items="${listOfEnquiry}">
        <div class="col-md-6 col-lg-4 mb-4">
          <div class="card shadow-sm border-0 rounded-4 h-100">
            <div class="card-body">
              <h5 class="card-title text-success fw-bold">${enquiry.enquiryPersonName}</h5>
              

              <ul class="list-group list-group-flush mt-3">
                <li class="list-group-item">
                  <strong>Enquiry ID:</strong> ${enquiry.enquiryId}
                </li>
                <li class="list-group-item">
                  <strong>Email Id:</strong> ${enquiry.enquiryPersonEmail}
                </li>
                <li class="list-group-item">
                  <strong>Subject:</strong> ${enquiry.enquirySubject}
                </li>
                <li class="list-group-item">
                  <strong>Message:</strong>
                  <p class="mb-0 mt-1">${enquiry.enquiryMessage}</p>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>
</body>
</html>