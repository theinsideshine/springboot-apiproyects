package com.theinsideshine.springboot.backend.apiprojectsviewer.controllers;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.services.IProyectService;

@CrossOrigin(origins= { "http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProyectRestController {

	@Autowired
	private IProyectService proyectService;	
	
	
	@GetMapping("/proyects")
	public List<Proyect> index(){
		return proyectService.findAll();
	}
	
	@GetMapping("/proyects/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Proyect show(@PathVariable Long id){
		return proyectService.findbyId(id);
	}
	
	@PostMapping("/proyects")
	@ResponseStatus(HttpStatus.CREATED)
	public Proyect create(@RequestBody Proyect proyect){
		
		return proyectService.save(proyect);
	}
	
	@PutMapping("/proyects/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proyect update(@RequestBody Proyect proyect, @PathVariable Long id) {
	
		Proyect proyectCurrent = proyectService.findbyId(id);
		
		proyectCurrent.setName(proyect.getName());
		proyectCurrent.setIntention(proyect.getIntention());
		proyectCurrent.setTechnology(proyect.getTechnology());
		proyectCurrent.setEmail(proyect.getEmail());
		
		return proyectService.save(proyectCurrent);
		
	}
	
	@DeleteMapping("/proyects/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		proyectService.delete(id);
	}
	
}
