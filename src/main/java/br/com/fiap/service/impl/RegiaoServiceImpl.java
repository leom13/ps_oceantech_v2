package br.com.fiap.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.repository.RegiaoColetaRepository;
import br.com.fiap.service.RegiaoColetaService;

@Service
public class RegiaoServiceImpl implements RegiaoColetaService {

	@Autowired
	private RegiaoColetaRepository regiaoColetaRepository;

	@Override
	public List<RegiaoColetaModel> getAll() {
		return this.regiaoColetaRepository.findAll();
	}

	@Override
	public RegiaoColetaModel getById(String id) {
		return this.regiaoColetaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Região de coleta não encontrada!"));
	}

	@Override
	public RegiaoColetaModel save(RegiaoColetaModel regiao) {
		regiao.setDataInsercao(LocalDateTime.now());
		return this.regiaoColetaRepository.save(regiao);
	}

	@Override
	public RegiaoColetaModel update(String id, RegiaoColetaModel regiao) {
		regiao.setDataUltimaModificacao(LocalDateTime.now());
		RegiaoColetaModel reg = this.getById(id);
		reg.setCidade(regiao.getCidade());
		reg.setEstado(regiao.getEstado());
		reg.setDataUltimaModificacao(LocalDateTime.now());
		return this.regiaoColetaRepository.save(reg);
	}

	@Override
	public void delete(String id) {
		this.regiaoColetaRepository.deleteById(id);
	}

}
