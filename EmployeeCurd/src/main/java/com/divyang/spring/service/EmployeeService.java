package com.divyang.spring.service;

import java.util.HashSet;

import com.divyang.spring.model.Employee;

public class EmployeeService {
	
	HashSet <Employee>employeeService = new HashSet <Employee>();

	public String EmployeeCreate(Employee employee) {
		
		for(Employee e : employeeService){
			if(e.getEmail().equals(employee.getEmail())){
				return null;
			}
		}
		employeeService.add(employee);
		return employee.getId();
	}

	public boolean EmployeeUpdate(String id, Employee employee) {
		
		for(Employee e : employeeService){
			if(e.getId().equals(id)){
				e.setPinCode(employee.getPinCode());
				e.setBirthDate(employee.getBirthDate());
				return true;
			}
		}
		return false;
	}

	public boolean Employeedelete(String id) {
		for(Employee e : employeeService){
			if(e.getId().equals(id)){
				employeeService.remove(e);
				return true;
			}
		}
		return false;
	}

}
