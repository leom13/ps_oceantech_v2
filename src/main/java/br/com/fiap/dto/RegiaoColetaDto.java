package br.com.fiap.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegiaoColetaDto {
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
}
