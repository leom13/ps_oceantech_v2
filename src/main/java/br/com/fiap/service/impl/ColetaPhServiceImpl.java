package br.com.fiap.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.ColetaPH;
import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.ColetaPhRepository;
import br.com.fiap.repository.RegiaoColetaRepository;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.service.ColetaPhService;

@Service
public class ColetaPhServiceImpl implements ColetaPhService {

	@Autowired
	private ColetaPhRepository coletaPhRepository;
	
	@Autowired
	private UsuarioRepository usuarioPhRepository;
	
	@Autowired
	private RegiaoColetaRepository regiaoColetaRepository;

	@Override
	public List<ColetaPH> getAll() {
		return this.coletaPhRepository.findAll();
	}

	@Override
	public ColetaPH getById(String id) {
		return this.coletaPhRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Registro de PH não foi encontrado!"));
	}

	@Override
	public ColetaPH save(ColetaPH ph) {
		
		ph.setDataInsercao(LocalDateTime.now());
		
		UsuarioModel usuario = this.usuarioPhRepository.findById(ph.getUsuario().getId())
				.orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado!"));
		ph.setUsuario(usuario);

		RegiaoColetaModel regiao = this.regiaoColetaRepository.findById(ph.getRegiao().getId())
				.orElseThrow(() -> new IllegalArgumentException("Regiao não foi encontrada"));
		ph.setRegiao(regiao);
		
		
		return this.coletaPhRepository.save(ph);
	}

	@Override
	public ColetaPH update(String id, ColetaPH ph) {
		
		ColetaPH colPh = this.getById(id);
		colPh.setPh(ph.getPh());
		colPh.setDataColeta(ph.getDataColeta());
		
		this.usuarioPhRepository.findById(ph.getUsuario().getId())
		.orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado!"));
		colPh.setUsuario(ph.getUsuario());
		
		this.regiaoColetaRepository.findById(ph.getRegiao().getId())
		.orElseThrow(() -> new IllegalArgumentException("Regiao não foi encontrada"));
		colPh.setRegiao(ph.getRegiao());
		
		ph.setDataUltimaModificacao(LocalDateTime.now());

		return this.coletaPhRepository.save(colPh);
	}

	@Override
	public void delete(String id) {
		this.coletaPhRepository.deleteById(id);
	}

}
