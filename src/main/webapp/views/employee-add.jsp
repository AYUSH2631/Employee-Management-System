<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD Employee</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
 background-image: url('https://media.istockphoto.com/id/1245982440/vector/man-looking-at-cv-profile-and-make-examination-hr-manager-making-resume-examination.jpg?s=612x612&w=0&k=20&c=hcpBuYk92VVJ04b99cch39nynh68ujEnObfeUOjxtoc=');        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: rgba(192, 192, 192, 0.7); /* Light grey shade */
        border-radius: 10px;
        padding: 20px;
        margin-top: 20px;
        max-width: 500px; /* Adjust the maximum width as needed */
    }

    .container .float-right {
        margin-bottom: 20px;
    }
</style>
</head>
<body>

<div class="container">

  <!-- Logout Link -->
  <div class="float-right">
    <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
  </div>

  <!-- Form Section -->
  <div class="row justify-content-center">
    <div class="col-md-6">
      <form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
        <!-- Name Input -->
        <div class="form-group">
          <label for="fname">Enter Name:</label>
          <input type="text" class="form-control" id="fname" name="fname" value="${employee.name}" placeholder="Enter Name" required>
        </div>

        <!-- Date of Birth Input -->
        <div class="form-group">
          <label for="dob">Enter Date of Birth:</label>
          <input type="date" class="form-control" id="dob" name="dob" value="${employee.dob}" required>
        </div>

        <!-- Department Input -->
        <div class="form-group">
          <label for="department">Enter Department:</label>
          <input type="text" class="form-control" id="department" name="Department" value="${employee.department}" placeholder="Enter Department" required>
        </div>

        <!-- Employee ID (Hidden) -->
        <input type="hidden" value="${employee.id}" name="id">

        <!-- Submit Button -->
        <button class="btn btn-primary" type="submit">Save Employee Data</button>
      </form>
    </div>
  </div>
  
</div>

</body>
</html>
