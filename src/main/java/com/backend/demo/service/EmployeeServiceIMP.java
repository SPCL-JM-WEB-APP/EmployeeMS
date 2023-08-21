package com.backend.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.demo.exception.ResourceNotFound;
import com.backend.demo.model.Employee;
import com.backend.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMP implements EmployeeService {
	private EmployeeRepository employeeRepo;

	public EmployeeServiceIMP(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id).orElseThrow(()->new ResourceNotFound("Employee","Id",id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check weather employee with given id exist in DB or not???
		
		Employee existingEmployee=employeeRepo.findById(id)
				.orElseThrow(()->new ResourceNotFound("Employee","Id",id));
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		employeeRepo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		//check the employee exist or not??
		
		employeeRepo.findById(id).orElseThrow(()->new ResourceNotFound("Employee","Id",id));
		employeeRepo.deleteById(id);
	}
	

}
