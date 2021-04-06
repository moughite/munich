package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.error.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmpById(long id){
		return employeeRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Employee "+id+" Not found"));
	}
	
	public List<Employee> getByFirstName(String fn){
		return employeeRepository.findByfirstName(fn);
	}
	public List<Employee> getByFirstNameAndLastName(String fn,String ln){
		return employeeRepository.findByfirstNameAndlastName(fn, ln);
	}
	
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void updateEmployee(Employee emp) {
		employeeRepository.save(emp);
	}
	
	public void deleteEmployee(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	
	public List<Employee> getEmployeeByDepartementId(long id){
		return employeeRepository.findAllEmployeeBydepId(id);
	}
	
}
