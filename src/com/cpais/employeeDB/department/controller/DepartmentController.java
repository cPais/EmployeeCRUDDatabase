package com.cpais.employeeDB.department.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpais.employeeDB.department.DAO.DepartmentDAO;
import com.cpais.employeeDB.department.entity.Department;
import com.cpais.employeeDB.department.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/list")
	public String listDepartments(Model theModel){
		
		List<Department> theDepartments = departmentService.getDepartments();
		theModel.addAttribute("departments", theDepartments);
		
		return "department-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Department theDepartment = new Department();
		theModel.addAttribute("department",theDepartment);
		
		return "department-form";
	}
	
	@PostMapping("saveDepartment")
	public String saveDepartment(@Valid @ModelAttribute("department") Department theDepartment, 
								BindingResult theBindingResult, Model theModel){
		
		if(theBindingResult.hasErrors()){
			return "department-form";
		}
		else{
		departmentService.saveDepartment(theDepartment);
		
		return "redirect:/department/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel, 
									@RequestParam("departmentId") int theId){
		
		Department theDepartment = departmentService.getDepartment(theId);
		theModel.addAttribute("department",theDepartment);
		
		
		return "department-form";
		
	}
	
	@GetMapping("delete")
	public String deleteDepartment(@RequestParam("departmentId") int theId){
		
		departmentService.deleteDepartment(theId);
		
		return "redirect:/department/list";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
		
	}

}
