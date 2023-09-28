<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Lists</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
 <link href="Employeeinfo/src/main/webapp/views/style.css
 " rel="stylesheet">
 
  <style>
    body {
        background-image: url('https://as2.ftcdn.net/v2/jpg/04/46/84/87/1000_F_446848761_TrpROaM3GGXPVlSWzEizpg6vTUS35pGO.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        height: 100vh;
        margin: 0; /* Remove default margin */
        padding: 0; /* Remove default padding */
    }

    .container {
        background-color: rgba(192, 192, 192, 0.7); /* Grey background with some transparency */
        border-radius: 10px; /* Rounded corners */
        padding: 20px;
        margin-top: 20px; /* Add some space from the top */
    }

    .container .float-right {
        margin-bottom: 20px; /* Add space at the bottom of the "Logout" link */
    }

    /* Your existing CSS styles... */
</style>
  
</head>
<body>



<%
 String email=(String)session.getAttribute("email");

if(email==null)
	response.sendRedirect("index.jsp");

%>


<div class="container">


<div class="float-right">
	<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
</div>
<p>${message }</p>
<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
<table border="1" class="table table-striped table-bordered">
    <tr class="thead-dark">
        <th>Name</th>
        <th>Department</th>
        <th>Date of Birth</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${list}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.department}</td>
            <td>${employee.dob}</td>
            <td>
            <a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id }">Edit</a> |
            <a href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id }">DELETE</a>
            
            </td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
