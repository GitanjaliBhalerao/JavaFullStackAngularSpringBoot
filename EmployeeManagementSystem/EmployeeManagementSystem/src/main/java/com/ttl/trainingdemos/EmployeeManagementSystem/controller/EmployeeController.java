package com.ttl.trainingdemos.EmployeeManagementSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ttl.trainingdemos.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.ttl.trainingdemos.EmployeeManagementSystem.model.Employee;
import com.ttl.trainingdemos.EmployeeManagementSystem.repository.EmployeeRepository;

//controller is responsible for performing CRUD operations on Employee Entity
//Spring data JPA >> EmployeeRepository


@CrossOrigin(origins = "http://localhost:4200") //for using spring boot restful web service for angular frontend
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("emp not found " + employeeId));

		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@RequestBody Employee empDetailsfromUser) throws ResourceNotFoundException {
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("emp not found " + employeeId));

		// update the employee details

		employee.setEmailId(empDetailsfromUser.getEmailId());
		employee.setFirstName(empDetailsfromUser.getFirstName());
		employee.setLastName(empDetailsfromUser.getLastName());

		final Employee updatedEmp = employeeRepository.save(employee);

		return ResponseEntity.ok(updatedEmp);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("emp not found " + employeeId));

		employeeRepository.delete(employee);

		Map<String, Boolean> resMap = new HashMap<String, Boolean>();
		resMap.put("deleted", Boolean.TRUE);
		return resMap;

	}

}
