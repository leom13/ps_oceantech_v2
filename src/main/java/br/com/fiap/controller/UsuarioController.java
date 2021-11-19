package br.com.fiap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.UsuarioDto;
import br.com.fiap.model.UsuarioModel;
import br.com.fiap.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioModel> getAll(){
		return this.usuarioService.getAll();
	}
	
	@GetMapping("/{id}")
	public UsuarioModel getById(@PathVariable String id) {
		return this.usuarioService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> save(@RequestBody @Valid UsuarioDto usuarioDto){
		UsuarioModel usuarioModel = new UsuarioModel();
		BeanUtils.copyProperties(usuarioDto, usuarioModel);
		usuarioService.save(usuarioModel);
		return new ResponseEntity<>(usuarioModel, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> update(@PathVariable String id, @RequestBody UsuarioDto usuarioDto) {
		UsuarioModel usuarioModel = new UsuarioModel();
		BeanUtils.copyProperties(usuarioDto, usuarioModel);
		usuarioService.update(id, usuarioModel);
		return new ResponseEntity<>(usuarioModel, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		this.usuarioService.delete(id);
		return id + ": Excluido com sucesso"; 
	}
	
	
	
	
	
	
}
