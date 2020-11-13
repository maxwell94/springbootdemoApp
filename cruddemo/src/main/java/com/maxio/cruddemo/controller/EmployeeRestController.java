package com.maxio.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxio.cruddemo.entity.Employee;
import com.maxio.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();
	}

	// get one employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee not found! - " + employeeId);
		}

		return employee;
	}

	// add employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}

	// update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	}

	// delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employe id not found!");
		}

		employeeService.deleteEmployeById(employeeId);

		return "Employe with id - " + employeeId + " deleted with success!";
	}

}
