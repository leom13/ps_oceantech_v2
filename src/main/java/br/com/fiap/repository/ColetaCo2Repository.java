package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.model.ColetaCo2;

public interface ColetaCo2Repository extends MongoRepository<ColetaCo2, String> {

}
