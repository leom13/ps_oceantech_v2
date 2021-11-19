package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.model.ColetaPH;

public interface ColetaPhRepository extends MongoRepository<ColetaPH, String> {

}
