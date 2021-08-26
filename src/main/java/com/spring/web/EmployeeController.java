package com.spring.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public ModelAndView getEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		HashMap<String, List<Employee>> model = new HashMap<>();
		model.put("list", employees);
		return new ModelAndView("employeeList", model);
	}

}
