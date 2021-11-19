package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.model.RegiaoColetaModel;

public interface RegiaoColetaRepository extends MongoRepository<RegiaoColetaModel, String> {

}
