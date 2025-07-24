<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register page</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>

	function validate(){
		let pwd=document.getElementById("pwd").value;
		let conpwd=document.getElementById("conpwd").value;
		if(pwd==conpwd){
			return true;
		}
		alert("password and confirm password must be same")
		return false;
	}
</script>
  <style>
	body{
		background-color:#f0f2f5;
		/*
		background-image: url(images/bank.jpg);
		background-repeat: no-repeat;
		background-size: cover;
		*/
	}
</style>
</head>
<body>
	<div class="container-fluid">
		  <div class="row">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 mt-5">
		<div class="card">
			<div class="card-header text-center">
				Update page
			</div>
			<div class="card-body">
				<form action="update1" method="post" onsubmit="return validate()">
			       	<div class="mb-3">
			       	Email
			       	<input type="email" name="email" value="${update.email}"class="form-control" placeholder="Enter Email" required="required" readonly="readonly">
			       </div>
			       <div class="mb-3">
			       	Password
			       	<input type="password" name="pwd"  id="pwd" class="form-control" placeholder="Enter password" required="required">
			       </div>
			       <div class="mb-3">
			       	Confirm Password
			       	<input type="password" name="conpwd" id="conpwd" class="form-control"placeholder="Enter confirm password" required="required">
			       </div>
			       <div class="mb-3">
			       	Phone
			       	<input type="tel" name="phone" class="form-control" placeholder="Enter phone" required="required">
			       </div>
			       <div class="mb-3">
			       	Gender<br>
			       	<input type="radio" name="gender" value="male">Male
			       	<input type="radio" name="gender" value="female">Female
			       </div>
			       <div>
			       	<button type="submit" class="btn btn-outline-success">Submit</button>
			       	<button type="submit" class="btn btn-outline-danger">Reset</button>
			       </div>
			      </form>
			     
			</div>
			
			</div>
		<div class="col-sm-3">
		</div>
		</div>
		</div>
	</div>
</body>
</html>