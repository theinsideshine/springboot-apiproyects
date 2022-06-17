package com.theinsideshine.springboot.backend.apiprojectsviewer.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
