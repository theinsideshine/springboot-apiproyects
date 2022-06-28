package com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;

public interface IProyectDao extends JpaRepository<Proyect, Long>{

}
