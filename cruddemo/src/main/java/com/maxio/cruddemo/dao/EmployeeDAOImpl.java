package com.maxio.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maxio.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

		// execute the query and get result
		List<Employee> employees = query.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);

		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployeById(int id) {

		/*
		 * Session currentSession = entityManager.unwrap(Session.class); Query query =
		 * currentSession.createQuery("delete from Employee where id=:employeeId");
		 * query.setParameter("employeeId", id); query.executeUpdate();
		 */
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = getEmployeeById(id);

		currentSession.delete(employee);

	}

}
