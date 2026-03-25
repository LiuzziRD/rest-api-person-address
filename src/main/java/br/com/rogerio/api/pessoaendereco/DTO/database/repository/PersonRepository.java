package br.com.rogerio.api.pessoaendereco.DTO.database.repository;

import br.com.rogerio.api.pessoaendereco.database.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
