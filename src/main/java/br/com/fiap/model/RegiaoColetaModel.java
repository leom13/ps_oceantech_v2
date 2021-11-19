package br.com.fiap.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "regiao-coleta")
public class RegiaoColetaModel {
	@Id
	private String id;
	
	private String cidade;
	
	private String estado;
	
    private LocalDateTime dataInsercao;
	
	private LocalDateTime dataUltimaModificacao;
}
