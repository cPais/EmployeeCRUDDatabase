package com.cpais.employeeDB.employee.DAO;

import java.util.List;

import com.cpais.employeeDB.employee.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();

	public void save(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId); 

}
