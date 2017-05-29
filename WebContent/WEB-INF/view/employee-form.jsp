<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

	<head>
		<title>Employee Form</title>
		
		<style>
			.error{
			color:red;
			display:block;
			}
		</style>
	</head>
	
	<div id="wrapper">
		<div id="header">
			<h2>Employee Form</h2>
		</div>
	</div>
	
	<body>
		<div id="container">
			<form:form action="saveEmployee"
					modelAttribute="employee"
					method="POST">
			
			<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td> <label>First Name</label> </td>
							<td> <form:input path="firstName"/> </td>
							<form:errors path="firstName" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Last Name</label> </td>
							<td> <form:input path="lastName"/> </td>
							<form:errors path="lastName" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Gender</label> </td>
							<td>  
								Male<form:radiobutton path="gender" value="Male" />
								Female<form:radiobutton path="gender" value="Female" />
							</td>
							<form:errors path="gender" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Department</label> </td>
							<td> 
								<form:select  path="department">
		     						<form:options items="${departments}" itemValue="departmentCode" itemLabel="departmentName" />
								</form:select>
							
							</td>
							<form:errors path="department" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Position</label> </td>
							<td> <form:input path="position"/> </td>
							<form:errors path="position" class="error"/>
						</tr>
						
						<tr>
							<td> <label>Salary</label> </td>
							<td> <form:input path="salary"/> </td>
							<form:errors path="salary" class="error"/>
						</tr>
						
						<tr>
							<td> <input type="submit" value="Save" class="save"/> </td>
						</tr>
						
					</tbody>
				</table>		
			
			</form:form> 
		<a href="${pageContext.request.contextPath}/employee/list">Back to List</a>
		</div>
	</body>
</html>