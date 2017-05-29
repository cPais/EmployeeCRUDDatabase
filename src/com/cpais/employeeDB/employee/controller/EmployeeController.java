package com.cpais.employeeDB.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpais.employeeDB.department.entity.Department;
import com.cpais.employeeDB.department.service.DepartmentService;
import com.cpais.employeeDB.employee.DAO.EmployeeDAO;
import com.cpais.employeeDB.employee.entity.Employee;
import com.cpais.employeeDB.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/list")
	public String listEmployees(Model theModel){
		
		List<Employee> theEmployees = employeeService.getEmployees();
		theModel.addAttribute("employees",theEmployees);
		
		return "employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee",theEmployee);
		
		List<Department> theDepartments = departmentService.getDepartments();
		theModel.addAttribute("departments",theDepartments);
		
		return "employee-form";
	}
	
	@PostMapping("saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		
		employeeService.save(theEmployee);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel){
		// retrieve the object from the database via ID passed in
			Employee theEmployee = employeeService.getEmployee(theId);
		
			List<Department> theDepartments = departmentService.getDepartments();
			theModel.addAttribute("departments",theDepartments);
			
		// save the object to the model so jsp has access
			theModel.addAttribute("employee",theEmployee);
		
		
		return "employee-form";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId){
		
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}

}
