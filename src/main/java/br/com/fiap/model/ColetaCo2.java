package br.com.fiap.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="coleta-co2")
public class ColetaCo2 {
	@Id
	private String id;
	
	private double co2;
	
	private LocalDate dataColeta;
	
	private LocalDateTime dataInsercao;
	
	private LocalDateTime dataUltimaModificacao;
	
	@DBRef
	private UsuarioModel usuario;
	
	@DBRef
	private RegiaoColetaModel regiao;
	
}
