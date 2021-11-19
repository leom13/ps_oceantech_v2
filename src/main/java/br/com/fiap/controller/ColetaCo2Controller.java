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

import br.com.fiap.dto.ColetaCo2Dto;
import br.com.fiap.model.ColetaCo2;
import br.com.fiap.service.ColetaCo2Service;

@RestController
@RequestMapping("/coleta-co2")
public class ColetaCo2Controller {
	
	@Autowired
	private ColetaCo2Service coletaCo2Service;
	
	
	@GetMapping
	public List<ColetaCo2> getAll(){
		return this.coletaCo2Service.getAll();
	}
	
	@GetMapping("/{id}")
	public ColetaCo2 getById(@PathVariable String id) {
		return this.coletaCo2Service.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<ColetaCo2> save(@RequestBody @Valid ColetaCo2Dto colCo2Dto){
		ColetaCo2 colCo2Model = new ColetaCo2();
		BeanUtils.copyProperties(colCo2Dto, colCo2Model);
		coletaCo2Service.save(colCo2Model);
		return new ResponseEntity<>(colCo2Model, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ColetaCo2> update(@PathVariable String id, @RequestBody ColetaCo2Dto colCo2Dto) {
		ColetaCo2 colCo2Model = new ColetaCo2();
		BeanUtils.copyProperties(colCo2Dto, colCo2Model);
		coletaCo2Service.update(id, colCo2Model);
		return new ResponseEntity<>(colCo2Model, HttpStatus.OK);
	}
	
		@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		this.coletaCo2Service.delete(id);
		return id + ": Excluido com sucesso"; 
	}
}
