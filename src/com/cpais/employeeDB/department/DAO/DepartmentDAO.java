package com.cpais.employeeDB.department.DAO;

import java.util.List;

import com.cpais.employeeDB.department.entity.Department;

public interface DepartmentDAO {
	
	
	public List<Department> getDepartments();

	public void saveDepartment(Department theDepartment);

	public Department getDepartment(int theId);

	public void deleteDepartment(int theId);

}
