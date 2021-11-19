package br.com.fiap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.model.UsuarioModel;

public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {

}
