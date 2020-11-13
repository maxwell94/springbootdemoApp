package com.maxio.cruddemo.service;

import java.util.List;

import com.maxio.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployeById(int id);

}
