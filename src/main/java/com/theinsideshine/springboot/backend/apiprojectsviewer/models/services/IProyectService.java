package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.util.List;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;

public interface IProyectService {
	
	public List<Proyect> findAll();

}
