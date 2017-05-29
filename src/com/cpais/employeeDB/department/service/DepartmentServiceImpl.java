package com.cpais.employeeDB.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpais.employeeDB.department.DAO.DepartmentDAO;
import com.cpais.employeeDB.department.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired 
	private DepartmentDAO departmentDAO;
	
	@Override
	@Transactional
	public List<Department> getDepartments() {
		
		return departmentDAO.getDepartments();
	}

	@Override
	@Transactional
	public void saveDepartment(Department theDepartment) {
		
		departmentDAO.saveDepartment(theDepartment);
		
	}

	@Override
	@Transactional
	public Department getDepartment(int theId) {
		
		return departmentDAO.getDepartment(theId);
		
	}

	@Override
	@Transactional
	public void deleteDepartment(int theId) {
		departmentDAO.deleteDepartment(theId);
		
	}

}
