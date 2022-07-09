package com.theinsideshine.springboot.backend.apiprojectsviewer.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Region;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.services.IProyectService;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.services.IUploadFileService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProyectRestController {

	@Autowired
	private IProyectService proyectService;

	@Autowired
	private IUploadFileService uploadService;

	private final Logger log = LoggerFactory.getLogger(ProyectRestController.class);

	@GetMapping("/proyects")
	public List<Proyect> index() {
		return proyectService.findAll();
	}

	@GetMapping("/proyects/page/{page}")
	public Page<Proyect> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return proyectService.findAll(pageable);
	}

	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/proyects/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Proyect proyect = null;
		Map<String, Object> response = new HashMap<>();

		try {
			proyect = proyectService.findbyId(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (proyect == null) {
			response.put("mensaje", "El proyecto ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Proyect>(proyect, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/proyects")
	public ResponseEntity<?> create(@Valid @RequestBody Proyect proyect, BindingResult result) {

		Proyect proyectNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			proyectNew = proyectService.save(proyect);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("proyect", proyectNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/proyects/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Proyect proyect, BindingResult result, @PathVariable Long id) {

		Proyect proyectCurrent = proyectService.findbyId(id);

		Proyect proyectUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (proyectCurrent == null) {
			response.put("mensaje", "Error: no se pudo editar, el proyecto ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			proyectCurrent.setName(proyect.getName());
			proyectCurrent.setIntention(proyect.getIntention());
			proyectCurrent.setTechnology(proyect.getTechnology());
			proyectCurrent.setEmail(proyect.getEmail());
			proyectCurrent.setCreateAt(proyect.getCreateAt());
			proyectCurrent.setRegion(proyect.getRegion());

			proyectUpdated = proyectService.save(proyectCurrent);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el proyecto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proyecto ha sido actualizado con éxito!");
		response.put("proyect", proyectUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/proyects/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		Proyect proyect = proyectService.findbyId(id);

		if (!file.isEmpty()) {
			String fileName = null;
			try {
				fileName = uploadService.copy(file);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen del proyecto");
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String nameImagenPrevious = proyect.getImage();

			uploadService.delete(nameImagenPrevious);

			proyect.setImage(nameImagenPrevious);

			proyect.setImage(fileName);
			proyectService.save(proyect);

			response.put("proyect", proyect);
			response.put("mensaje", "Has subido correctamente la imagen: " + fileName);

		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/proyects/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {

			Proyect proyect = proyectService.findbyId(id);
			String nameImagenPrevious = proyect.getImage();
			nameImagenPrevious = proyect.getImage();

			uploadService.delete(nameImagenPrevious);
			proyectService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el proyecto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proyecto eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/uploads/img/{nameImage:.+}")
	public ResponseEntity<Resource> imageView(@PathVariable String nameImage) {

		Resource resource = null;

		try {
			resource = uploadService.load(nameImage);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/proyects/regions")
	public List<Region> listRegions(){
		return proyectService.findAllRegions();
	}

}
