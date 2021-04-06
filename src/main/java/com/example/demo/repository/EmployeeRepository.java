package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	public List<Employee> findByfirstName(String fn);
	
	@Query("select emp from Employee emp where emp.firstName=:firstNameBind and emp.lastName=:lastNamebind")
	public List<Employee> findByfirstNameAndlastName(@Param("firstNameBind") String fn,
			                                         @Param("lastNamebind") String ln);
	
	public List<Employee> findAllEmployeeBydepId(long id);
}
