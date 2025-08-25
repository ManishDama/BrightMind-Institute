<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<table class="table table-striped">
<thead>
	<th>Email</th>
	<th>Phone</th>
	<th>Gender</th>
	<th>Desig</th>
	<th>Update</th>
	<th>Delete</th>
</thead>
<c:forEach var="name" items="${users}">
	<tr>
		<td>${name.email}</td>
		<td>${name.phone}</td>
		<td>${name.gender}</td>
		<td>${name.desig}</td>
		<td><a class="btn btn-outline-primary" href="/update/${name.email}">Update</a></td>
		<td><a class="btn btn-outline-primary" href="/delete/${name.email}">Delete</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>