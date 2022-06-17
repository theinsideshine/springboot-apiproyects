package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.util.List;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;

public interface IProyectService {
	
	public List<Proyect> findAll();
	
	public Proyect findbyId( Long Id); 
	
    public Proyect save(Proyect proyect);
    
    public void delete (Long id);
    
    

}
