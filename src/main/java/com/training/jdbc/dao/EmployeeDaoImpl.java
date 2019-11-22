package com.training.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.jdbc.bean.Employee;
import com.training.myapp.dbUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public boolean addNewEmployee(Employee employee) {
		String query = "INSERT INTO employees VALUES(?, ?, ?, ?)";

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getEmployeeName());
			statement.setString(3, employee.getEmployeeDepartment());
			statement.setInt(4, employee.getEmployeeSalary());
			
			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteNewEmployee(int employeeId) {
		String query = "DELETE FROM employees WHERE employeeId = " + employeeId;

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Employee> findAllEmployees() {
		String query = "SELECT * FROM employees";
		List<Employee> employees = new ArrayList<Employee>();

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			while (result.next()) {
				Employee employee = new Employee(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Employee findEmployeeById(int employeeId) {
		String query = "SELECT * FROM employees WHERE employeeId = " + employeeId;
		Employee employee = null;

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			if (result.next())
				employee = new Employee(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	public boolean updateEmployee(Employee employee) {
		String query = "UPDATE employees SET employeeDepartment=?, employeeSalary=? WHERE employeeId=?";

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, employee.getEmployeeDepartment());
			statement.setInt(2, employee.getEmployeeSalary());
			statement.setInt(3, employee.getEmployeeId());

			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
