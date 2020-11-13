package com.maxio.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxio.cruddemo.dao.EmployeeDAO;
import com.maxio.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {

		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {

		return employeeDao.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeById(int id) {
		employeeDao.deleteEmployeById(id);
	}

}
