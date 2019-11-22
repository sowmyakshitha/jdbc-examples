package com.training.jdbc.test;

import java.util.List;

import com.training.jdbc.bean.Employee;
import com.training.jdbc.dao.EmployeeDao;
import com.training.jdbc.dao.EmployeeDaoImpl;

public class TestEmployee {
	
public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		 Employee employee = new Employee(104, "Manu", "HR", 25000);
		//Employee employee5 = new Employee(105, "Pinky", "ADMIN", 88000);
		//Employee employee6 = new Employee(106, "Monika", "ADMIN", 99000);
	
		if(dao.addNewEmployee(employee))
			System.out.println("Employee record added successfully.");
		else
			System.out.println("Failed to add Employee record.");
		
		
		if(dao.deleteNewEmployee(102)) 
			System.out.println("Employee record deleted successfully");
		else
			System.out.println("Employee record not found.");
		
		
		
//		List<Employee> employees = dao.findAllEmployees();
//		
//		employees.forEach(System.out::println);
		
		
//		Employee employee = dao.findEmployeeById(103);
//		if(employee != null)
//			System.out.println(employee);
//		else
//			System.out.println("Employee record not found.");
//		
//		Employee employee = dao.findEmployeeById(103);
//		if(employee != null) {
//			employee.setEmployeeSalary(60000);
//			if(dao.updateEmployee(employee))
//				System.out.println("Employee record updated successfully");
//		}
//		else
//			System.out.println("Employee record not found.");
//		

}}
