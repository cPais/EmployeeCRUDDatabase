<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Department Listings</title>
		
		<link type="text/css"
		      rel="stylesheet"
		      href="${pageContext.request.contextPath}/resources/css/style.css">		
	</head>
	
	<div id="wrapper">
		<div id="header">
			<h2>Department Listings</h2>
		</div>
	</div>
	
	
	<body>
	<hr>
	<input type="button" 
			value="Add a Department" 
			onclick="window.location.href='showFormForAdd'"
			class="add-button">
			
		<div id="container">
			<table>
				<tr>
					<th>Department Name</th>
					<th>Department Code</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempDepartment" items="${departments}">
					
					<c:url var="updateLink" value="/department/showFormForUpdate">
						<c:param name="departmentId" value="${tempDepartment.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/department/delete">
						<c:param name="departmentId" value="${tempDepartment.id}"/>
					</c:url>
					
					<tr>
						<td>${tempDepartment.departmentName}</td>
						<td>${tempDepartment.departmentCode}</td>
						<td><a href="${updateLink} ">Update</a>
						|
						<a href="${deleteLink}" 
							onclick ="if(!(confirm('Are you sure you wish to delete this department record?')))return false">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		<hr>
		<a href="${pageContext.request.contextPath}/employee/list">To Employee List</a>
	</body>
	
</html>