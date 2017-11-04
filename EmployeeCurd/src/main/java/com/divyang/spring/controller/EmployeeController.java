package com.divyang.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divyang.spring.model.Employee;
import com.divyang.spring.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	   private EmployeeService employeeService;

	   /*---Add new book---*/
	   @PostMapping("/employee")
	   public ResponseEntity<?> save(@RequestBody Employee employee) {
	      String id = employeeService.EmployeeCreate(employee);
	      if(null == id){
	    	  return ResponseEntity.badRequest().body("Email Id Already Exist ,Please Try with other Email-Id");
	      }
	      else{
	    	  return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	      }
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/employee/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Employee employee) {
		  boolean b =employeeService.EmployeeUpdate(id, employee);
		  if(b){
			  return ResponseEntity.ok().body("Employee has been updated successfully."); 
		  }
		  else{
			  return ResponseEntity.badRequest().body("Bad Request.");
		  }
	      
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/employee/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") String id) {
		  boolean b = employeeService.Employeedelete(id); 
		  if(b){
			  return ResponseEntity.ok().body("Employee has been deleted successfully."); 
		  }
		  else{
			  return ResponseEntity.badRequest().body("Bad Request.");
		  }
	   }
	}

}
