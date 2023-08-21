package com.backend.demo.controller;

//@pathvariable used to extract the value from the URI
//@RequestBody indicates that spring should  deserialize a request body into object
//Response Entity to represent the whole HTTP Response.

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.model.Employee;
import com.backend.demo.service.EmployeeService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private EmployeeService  employeeService ;

public EmployeeController(EmployeeService employeeService) 
{
	super();
	this.employeeService = employeeService;
}
//build create employee REST API
@PostMapping("/insert")

public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee)
{
	return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
}
//build get all Employees REST API


 	 @GetMapping("/all")
public List<Employee>getEmployees()
{
	return employeeService.getAllEmployees();
}
//build get  Employees by id REST API
@GetMapping("{id}")
public ResponseEntity<Employee>getEmployeeById(@PathVariable("id")long employeeId)
{
	return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);	
}
//build update Employee REST API

@PutMapping("{id}")
public ResponseEntity<Employee>updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee)
		{
	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		}
//delete employee from DB
@DeleteMapping("{id}")
public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id)
{
	employeeService.deleteEmployee(id);
	return new ResponseEntity<String>("Employee Deleted Successfully!!..",HttpStatus.OK);
}
}
