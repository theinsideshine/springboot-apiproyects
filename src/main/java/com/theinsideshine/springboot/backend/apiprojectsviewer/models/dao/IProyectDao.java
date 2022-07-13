package com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Region;

public interface IProyectDao extends JpaRepository<Proyect, Long>{
	
	
	@Query("from Region")
	public List<Region> findAllRegions();

}
