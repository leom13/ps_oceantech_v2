package br.com.fiap.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.model.UsuarioModel;
import lombok.Data;
@Data
public class ColetaPhDto {


	private double ph;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataColeta;
	
	@DBRef
	private UsuarioModel usuario;
	
	@DBRef
	private RegiaoColetaModel regiao;
}
