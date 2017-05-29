package com.cpais.employeeDB.employee.service;

import java.util.List;

import com.cpais.employeeDB.employee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public void save(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
