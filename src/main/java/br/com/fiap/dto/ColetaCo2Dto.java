package br.com.fiap.dto;

import java.time.LocalDate;

//import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.fiap.model.RegiaoColetaModel;
import br.com.fiap.model.UsuarioModel;
import lombok.Data;

@Data
public class ColetaCo2Dto {
	
	
	private double co2;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataColeta;
	
	@DBRef
	private UsuarioModel usuario;
	
	@DBRef
	private RegiaoColetaModel regiao;
}
