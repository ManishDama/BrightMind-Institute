<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
  body, html {
    height: 100%;
    margin: 0;
    background: url('https://images.pexels.com/photos/5212333/pexels-photo-5212333.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650') no-repeat center center fixed;
    background-size: cover;
  }

  .login-wrapper {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    backdrop-filter: blur(4px);
  }

  .login-card {
    background: rgba(255, 255, 255, 0.95);
    padding: 2rem;
    border-radius: 1rem;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
    max-width: 400px;
    width: 100%;
  }
</style>
</head>
<body>

<div class="login-wrapper mt-3">
  <div class="login-card">
    <h3 class="text-center text-primary mb-4 fw-bold">Login</h3>

    <div class="text-center mb-3">
      <span class="text-success fw-semibold">${msg1}</span>
    </div>

    <form action="login" method="post">
      <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" placeholder="Enter Email" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Enter Password" required>
      </div>

      <div class="d-grid gap-2">
        <button type="submit" class="btn btn-success">Login</button>
        <button type="reset" class="btn btn-danger">Reset</button>
        <a class="btn btn-secondary" href="/">Back to Home</a>
      </div>
    </form>

    <div class="text-center mt-3">
      <span class="text-danger">${msg}</span><br>
      <span class="text-success">${msg2}</span>
    </div>

  </div>
</div>

</body>
</html>
