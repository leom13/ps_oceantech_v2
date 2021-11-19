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

import br.com.fiap.dto.RegiaoColetaDto;
import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.service.RegiaoColetaService;

@RestController
@RequestMapping("/regiao-coleta")
public class RegiaoColetaController {
	
	@Autowired
	private RegiaoColetaService regiaoColetaService;
	
	@GetMapping
	public List<RegiaoColetaModel> getAll(){
		return this.regiaoColetaService.getAll();
	}
	
	@GetMapping("/{id}")
	public RegiaoColetaModel getById(@PathVariable String id) {
		return this.regiaoColetaService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<RegiaoColetaModel> save(@RequestBody @Valid RegiaoColetaDto regiaoColetaDto){
		RegiaoColetaModel regiaoModel  = new RegiaoColetaModel();
		BeanUtils.copyProperties(regiaoColetaDto,regiaoModel);
		regiaoColetaService.save(regiaoModel);
		return new ResponseEntity<>(regiaoModel, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RegiaoColetaModel> update(@PathVariable String id, @RequestBody RegiaoColetaDto regiaoColetaDto) {
		RegiaoColetaModel regiaoModel = new RegiaoColetaModel();
		BeanUtils.copyProperties(regiaoColetaDto, regiaoModel);
		regiaoColetaService.update(id, regiaoModel);
		return new ResponseEntity<>(regiaoModel, HttpStatus.OK);
	}
	
		@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		this.regiaoColetaService.delete(id);
		return id + ": Excluido com sucesso"; 
	}
}
