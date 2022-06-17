package com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;

public interface IProyectDao extends CrudRepository<Proyect, Long>{

}
