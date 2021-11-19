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

import br.com.fiap.dto.ColetaPhDto;
import br.com.fiap.model.ColetaPH;
import br.com.fiap.service.ColetaPhService;

@RestController
@RequestMapping("/coleta-ph")
public class ColetaPhController {
	
	@Autowired
	private ColetaPhService coletaPhService;
	
	@GetMapping
	public List<ColetaPH> getAll(){
		return this.coletaPhService.getAll();
	}
	
	@GetMapping("/{id}")
	public ColetaPH getById(@PathVariable String id) {
		return this.coletaPhService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<ColetaPH> save(@RequestBody @Valid ColetaPhDto colPhDto){
		ColetaPH colPhModel = new ColetaPH();
		BeanUtils.copyProperties(colPhDto, colPhModel);
		coletaPhService.save(colPhModel);
		return new ResponseEntity<>(colPhModel, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ColetaPH> update(@PathVariable String id, @RequestBody ColetaPhDto colPhDto) {
		ColetaPH colPhModel = new ColetaPH();
		BeanUtils.copyProperties(colPhDto, colPhModel);
		coletaPhService.update(id, colPhModel);
		return new ResponseEntity<>(colPhModel, HttpStatus.OK);
	}
	
		@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		this.coletaPhService.delete(id);
		return id + ": Excluido com sucesso"; 
	}
}
