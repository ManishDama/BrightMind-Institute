<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>user Home</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href=#>Logo</a>	
		<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#mymenu">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="mymenu">
			 <ul class="navbar-nav ms-auto">
			<li class="nav-item"><p class="navbar-text ms-auto me-3 my-auto text-white">${usermail}</p></li>
			<li>
					<a  class="nav-link text-white" href="/logout">logout</a>
				</li>
			</ul>
		</div>
	</div>	
</nav>
<h1>Hello user...</h1>
</body>
</html>