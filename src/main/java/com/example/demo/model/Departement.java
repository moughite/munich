package com.example.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departement")
public class Departement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "dep",cascade = CascadeType.REMOVE,orphanRemoval = true)	
	private List<Employee> emp;
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(long id, String name) {
		super();
		this.id = id;
		this.name = name;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Employee> getEmp() {
//		return emp;
//	}
//
//	public void setEmp(List<Employee> emp) {
//		this.emp = emp;
//	}

	
	

}
