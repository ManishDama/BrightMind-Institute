<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Enrollment Page</title>
</head>
<body>
<section class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6 shadow-lg p-5 bg-white rounded-4">
            <h2 class="text-center mb-4 text-primary fw-bold">Student Enrollment</h2>
            <form action="enrollstudent" method="post">

                <!-- Hidden Announcement ID -->
                <input type="hidden" name="announcementId" value="${announceId}">

                <!-- Full Name -->
                <div class="mb-3">
                    <label for="enrollStudentName" class="form-label fw-semibold">Full Name</label>
                    <input type="text" class="form-control" name="enrollStudentName" id="enrollStudentName" placeholder="Enter your full name" required>
                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label for="enrollStudentEmail" class="form-label fw-semibold">Email</label>
                    <input type="email" class="form-control" name="enrollStudentEmail" id="enrollStudentEmail" placeholder="Enter your email" required>
                </div>

                <!-- Phone -->
                <div class="mb-4">
                    <label for="enrollStudentPhone" class="form-label fw-semibold">Phone Number</label>
                    <input type="tel" class="form-control" name="enrollStudentPhone" id="enrollStudentPhone" placeholder="Enter your phone number" pattern="[6-9]{1}[0-9]{9}" maxlength="10" required>
                </div>
                
                <div class="text-center mb-4" style="font-family: Arial, sans-serif;">
    					<span class="text-center text-success">${msg}</span>
				</div>
				 
                <!-- Buttons -->
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-success px-4 me-3">Submit</button>
                    <a href="/" class="btn btn-outline-secondary px-4 me-3">Cancel</a>
                    <a href="/" class="btn btn-outline-secondary px-4 ">Back to Home</a>
                </div>

            </form>
        </div>
    </div>
</section>

</body>
</html>