package br.com.fiap.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.UsuarioModel;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioModel> getAll() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public UsuarioModel getById(String id) {
		return this.usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado!"));
	}

	@Override
	public UsuarioModel save(UsuarioModel usuario) {
		usuario.setDataInsercao(LocalDateTime.now());
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public UsuarioModel update(String id, UsuarioModel usuario) {
		usuario.setDataUltimaModificacao(LocalDateTime.now());
		UsuarioModel user = this.getById(id);
		user.setNome(usuario.getNome());
		user.setSobrenome(usuario.getSobrenome());
		user.setEmail(usuario.getEmail());
		user.setSenha(usuario.getSenha());
		user.setDataUltimaModificacao(LocalDateTime.now());
		
		return this.usuarioRepository.save(user);
	}

	@Override
	public void delete(String id) {
		this.usuarioRepository.deleteById(id);

	}

}
