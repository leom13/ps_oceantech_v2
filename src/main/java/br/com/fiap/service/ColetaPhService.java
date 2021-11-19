package br.com.fiap.service;

import java.util.List;

import br.com.fiap.model.ColetaPH;

public interface ColetaPhService {
	public List<ColetaPH> getAll();
	
	public ColetaPH getById(String id);
	
	public ColetaPH save(ColetaPH ph);
	
	public ColetaPH update(String id, ColetaPH ph);
	   
	public void delete(String id);
	
}
