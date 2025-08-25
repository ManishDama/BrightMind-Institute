<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Announcement</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<%@ include file="adminmenu.jsp" %>
<section class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8 p-4 shadow rounded-4 bg-white">
            <h3 class="text-center mb-4 text-primary fw-bold">Update Announcement Details</h3>
            <form action="/updateannouncements" method="post" enctype="multipart/form-data">
                
                <input type="hidden" name="announcementId" value="${updateannouncement.announcementId}"/>
                <input type="hidden" name="oldImage" value="${updateannouncement.image}"/>

                <!-- Course Name -->
                <div class="mb-3">
                    <label class="form-label fw-semibold">Course Name</label>
                    <input type="text" class="form-control" name="announcingCourseTitle" value="${updateannouncement.announcingCourseTitle}" required>
                </div>

                <!-- Description -->
                <div class="mb-3">
                    <label class="form-label fw-semibold">Description</label>
                    <textarea class="form-control" name="description" rows="4" required>${updateannouncement.description}</textarea>
                </div>

                <!-- Price -->
                <div class="mb-3">
                    <label class="form-label fw-semibold">Price</label>
                    <input type="text" class="form-control" name="price" value="${updateannouncement.price}" required>
                </div>

                <!-- Start Date -->
                <div class="mb-3">
                    <label class="form-label fw-semibold">Batch Start Date</label>
                    <input type="date" class="form-control" name="batchStartDate" value="${updateannouncement.batchStartDate}" required>
                </div>
                <!-- Image Upload -->
                <div class="mb-3">
                    <label class="form-label fw-semibold">Upload New Image (optional)</label>
                    <input type="file" class="form-control" name="courseImageFile" accept=".jpg,.jpeg,.png">
                    <div class="mt-3">
                        <label class="text-muted">Current Image:</label><br>
                        <img src="/uploads/${updateannouncement.image}" class="img-thumbnail shadow-sm" style="height: 120px;">
                    </div>
                </div>

					<div class="m-2 text-center">
						<span class="text-success">${msg}</span>
					</div>
                <!-- Buttons -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-success px-4 me-2">Update</button>
                    <a href="/announcements" class="btn btn-secondary px-4">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</section>

</body>
</html>