package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departement;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartementService;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartementService departementService;

	@GetMapping("/employee")
	private List<Employee> getAllEmp() {
		return employeeService.getAllEmp();
	}

	@GetMapping("/employee/{id}")
	private Employee getEmpById(@PathVariable long id) {
		return employeeService.getEmpById(id);
	}

	@DeleteMapping("/employeedel/{id}")
	private void deleteEMploye(@PathVariable long id) {
		
		employeeService.deleteEmployee(employeeService.getEmpById(id));

	}

	@GetMapping("/employeefn/{fn}")
	private List<Employee> getEmpByFirstName(@PathVariable String fn) {
		return employeeService.getByFirstName(fn);
	}

	@GetMapping("/employeefnln/{fn}/{ln}")
	private List<Employee> getEmpByFirstNameAndLastName(@PathVariable String fn, @PathVariable String ln) {
		return employeeService.getByFirstNameAndLastName(fn, ln);
	}

	@PostMapping("/employeeadd/departement/{id}")
	private ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp, @PathVariable long id) {
		emp.setDep(departementService.getDepById(id));
		employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PutMapping("/employeeupdate")
	private void updateEmployee(@RequestBody Employee emp) {
		employeeService.updateEmployee(emp);
	}

	@GetMapping("/employee/departement/{id}")
	private List<Employee> getAllEmpByDepartementId(@PathVariable long id) {
		return employeeService.getEmployeeByDepartementId(id);
	}

}
