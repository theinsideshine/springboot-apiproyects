package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao.IProyectDao;
import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Proyect;

@Service
public class ProyectServiceImpl implements IProyectService{

	@Autowired
	private IProyectDao proyectDao;
	
	@Override
	@Transactional(readOnly= true)
	public List<Proyect> findAll() {
		
		return (List<Proyect>) proyectDao.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Proyect findbyId(Long Id) {
		
		return proyectDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Proyect save(Proyect proyect) {
		// TODO Auto-generated method stub
		return proyectDao.save(proyect);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		proyectDao.deleteById(id);
		
	}

}
