package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.ColetaCo2;

public interface ColetaCo2Service {
	public List<ColetaCo2> getAll();
	
	public ColetaCo2 getById(String id);
	
	public ColetaCo2 save(ColetaCo2 co2);
	
	public ColetaCo2 update(String id, ColetaCo2 co2);
	
	public void delete(String id);
}
