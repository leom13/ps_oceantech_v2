package br.com.fiap.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="coleta-ph")
public class ColetaPH {
	@Id
	private String id;
	
	private double ph;
	
	private LocalDate dataColeta;
	
	private LocalDateTime dataInsercao;
	
	private LocalDateTime dataUltimaModificacao;
	
	@DBRef
	private UsuarioModel usuario;
	
	@DBRef
	private RegiaoColetaModel regiao;
}
