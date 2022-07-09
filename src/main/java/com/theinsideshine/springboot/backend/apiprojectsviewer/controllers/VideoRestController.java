package com.theinsideshine.springboot.backend.apiprojectsviewer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Product;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Video;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.services.IProyectService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VideoRestController {
	
	@Autowired
	private IProyectService proyectService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Video show(@PathVariable Long id) {
		return proyectService.findVideoById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		proyectService.deleteVideoById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/videos/filter-products/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> filtrarProductos(@PathVariable String term){
		return proyectService.findProductByName(term);
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/videos")
	@ResponseStatus(HttpStatus.CREATED)
	public Video create(@RequestBody Video video) {
		return proyectService.saveVideo(video);
	}

}
