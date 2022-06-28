package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
