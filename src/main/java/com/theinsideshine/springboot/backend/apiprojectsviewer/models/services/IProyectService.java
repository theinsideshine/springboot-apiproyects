package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.util.List;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Region;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProyectService {
	
	public List<Proyect> findAll();
	
	public Page<Proyect> findAll(Pageable pageable);	
	
	public Proyect findbyId( Long Id); 
	
    public Proyect save(Proyect proyect);
    
    public void delete (Long id);
    
    public List<Region> findAllRegions();
    
    public Video findVideoById(Long id);
	
	public Video saveVideo(Video video);
	
	public void deleteVideoById(Long id);
    
    

}
