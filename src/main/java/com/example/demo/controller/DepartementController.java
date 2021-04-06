package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departement;
import com.example.demo.service.DepartementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Controller Employee", description = "das ist einen Kontroller Emp")
public class DepartementController {
	@Autowired
	DepartementService departementService;

	@ApiOperation(value = "find all Employee", notes = "das ist eine operation find all")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping("/departement")
	private List<Departement> getAllDepartements() {
		return departementService.getAllDepartement();
	}

	@GetMapping("/departement/{id}")
	private Departement getDepById(@PathVariable long id) {
		return departementService.getDepById(id);
	}

	@PostMapping("/departementadd")
	private void addDepartement(@RequestBody Departement dep) {
		departementService.addDepartement(dep);
	}

	@PutMapping("/departementupdate")
	private void updateDepartement(@RequestBody Departement dep) {
		departementService.addDepartement(dep);
	}

	@DeleteMapping("/departementdel/{id}")
	private void updateDepartement(@PathVariable long id) {
		departementService.deleteDepartementById(id);
	}

}
