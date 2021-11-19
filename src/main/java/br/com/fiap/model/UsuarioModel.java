package br.com.fiap.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "usuario")
public class UsuarioModel {
	
	@Id
	private String id;
	
	private String nome;
	
	private String sobrenome;
	
	private String email;
	
	private String senha;
	
	private LocalDateTime dataInsercao;
	
	private LocalDateTime dataUltimaModificacao;
	
}
