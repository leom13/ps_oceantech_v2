package br.com.fiap.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.ColetaCo2;
import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.ColetaCo2Repository;
import br.com.fiap.repository.RegiaoColetaRepository;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.service.ColetaCo2Service;

@Service
public class ColetaCo2ServiceImpl implements ColetaCo2Service {

	@Autowired
	private ColetaCo2Repository coletaCo2Repository;
	
	@Autowired
	private UsuarioRepository usuarioPhRepository;
	
	@Autowired
	private RegiaoColetaRepository regiaoColetaRepository;

	@Override
	public List<ColetaCo2> getAll() {
		return this.coletaCo2Repository.findAll();
	}

	@Override
	public ColetaCo2 getById(String id) {
		return this.coletaCo2Repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Registro de Co2 não foi encontrado!"));
	}

	@Override
	public ColetaCo2 save(ColetaCo2 co2) {
		co2.setDataInsercao(LocalDateTime.now());

		UsuarioModel usuario = this.usuarioPhRepository.findById(co2.getUsuario().getId())
				.orElseThrow(() -> new IllegalArgumentException("Usuario nao encontrado"));
		co2.setUsuario(usuario);
		
		RegiaoColetaModel regiao = this.regiaoColetaRepository.findById(co2.getRegiao().getId())
				.orElseThrow(() -> new IllegalArgumentException("Regiao nao encontrada"));
		co2.setRegiao(regiao);
		
		return this.coletaCo2Repository.save(co2);
	}

	@Override
	public ColetaCo2 update(String id, ColetaCo2 co2) {
		co2.setDataUltimaModificacao(LocalDateTime.now());
		ColetaCo2 colCo2 = this.getById(id);
		colCo2.setCo2(co2.getCo2());
		colCo2.setDataColeta(co2.getDataColeta());
		
		this.usuarioPhRepository.findById(co2.getUsuario().getId())
		.orElseThrow(() -> new IllegalArgumentException("Usuario nao encontrado"));
		colCo2.setUsuario(co2.getUsuario());
		
		this.regiaoColetaRepository.findById(co2.getRegiao().getId())
		.orElseThrow(() -> new IllegalArgumentException("Regiao nao encontrada"));
		colCo2.setRegiao(co2.getRegiao());
		
		return this.coletaCo2Repository.save(colCo2);
	}

	@Override
	public void delete(String id) {
		this.coletaCo2Repository.deleteById(id);

	}

}
