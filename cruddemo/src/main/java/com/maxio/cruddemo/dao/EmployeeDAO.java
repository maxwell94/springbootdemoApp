package com.maxio.cruddemo.dao;

import java.util.List;

import com.maxio.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void saveEmployee(Employee employee);

	public void deleteEmployeById(int id);

}
