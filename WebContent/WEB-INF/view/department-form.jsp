<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

	<head>
		<title>Department Form</title>
		
		<style>
			.error{
			color:red;
			display:block;
			}
		</style>
	</head>
	
	<div id="wrapper">
		<div id="header">
			<h2>Department Form</h2>
		</div>
	</div>
	
	<body>
		<div id="container">
			<form:form action="saveDepartment"
					modelAttribute="department"
					method="POST">
			
			<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td> <label>Department Name</label> </td>
							<td> <form:input path="departmentName"/> </td>
							<form:errors path="departmentName" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Department Code</label> </td>
							<td> <form:input path="departmentCode"/> </td>
							<form:errors path="departmentCode" class="error"/>
						</tr>
						
						<tr>
							<td> <input type="submit" value="Save" class="save"/> </td>
						</tr>
						
					</tbody>
				</table>		
			
			</form:form> 
		<a href="${pageContext.request.contextPath}/department/list">Back to List</a>
		</div>
	</body>
</html>