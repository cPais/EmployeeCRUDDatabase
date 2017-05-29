<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Employee Listings</title>
		
		<link type="text/css"
		      rel="stylesheet"
		      href="${pageContext.request.contextPath}/resources/css/style.css">		
	</head>
	
	<div id="wrapper">
		<div id="header">
			<h2>Employee Listings</h2>
		</div>
	</div>
	
	
	<body>
	<hr>
	<input type="button" 
			value="Add a Employee" 
			onclick="window.location.href='showFormForAdd'"
			class="add-button">
			
		<div id="container">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Department</th>
					<th>Position</th>
					<th>Salary</th>
					
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempEmployee" items="${employees}">
					
					<c:url var="updateLink" value="/employee/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}"/>
					</c:url>
					
					<tr>
						<td>${tempEmployee.firstName}</td>
						<td>${tempEmployee.lastName}</td>
						<td>${tempEmployee.gender}</td>
						<td>${tempEmployee.department}</td>
						<td>${tempEmployee.position}</td>
						<td>${tempEmployee.salary}</td>
						<td><a href="${updateLink} ">Update</a>
						|
						<a href="${deleteLink}" 
							onclick ="if(!(confirm('Are you sure you wish to delete this employee record?')))return false">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr>
		<a href="${pageContext.request.contextPath}/department/list">To Department List</a>
	</body>
	
</html>