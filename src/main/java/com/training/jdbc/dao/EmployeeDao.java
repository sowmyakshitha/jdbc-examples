package com.training.jdbc.dao;

import java.util.List;

import com.training.jdbc.bean.Employee;

public interface EmployeeDao {
	
	public boolean addNewEmployee(Employee employee);	
	public boolean deleteNewEmployee(int employeeId);
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(int employeeId);
	public boolean updateEmployee(Employee employee);

}
