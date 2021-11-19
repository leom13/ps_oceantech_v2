package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.UsuarioModel;

public interface UsuarioService {
	public List<UsuarioModel> getAll();
	
	public UsuarioModel getById(String id);
	
	public UsuarioModel save(UsuarioModel usuario);
	
	public UsuarioModel update(String id, UsuarioModel usuario);
	
	public void delete(String id);
}
