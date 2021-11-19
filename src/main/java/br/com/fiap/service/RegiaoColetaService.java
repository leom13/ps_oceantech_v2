package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.RegiaoColetaModel;

public interface RegiaoColetaService {
	public List<RegiaoColetaModel> getAll();
	
	public RegiaoColetaModel getById(String id);
	
	public RegiaoColetaModel save(RegiaoColetaModel regiao);
	
	public RegiaoColetaModel update(String id, RegiaoColetaModel regiao);
	
	public void delete(String id);
}
