package br.com.rogerio.api.pessoaendereco.service;


import br.com.rogerio.api.pessoaendereco.database.model.Person;
import br.com.rogerio.api.pessoaendereco.database.repository.PersonRepository;
import br.com.rogerio.api.pessoaendereco.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.NotAcceptableApiVersionException;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person person) {

        if (person.getAddresses() != null) {
            person.getAddresses().forEach(a -> a.setPerson(person));
        }

        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found."));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
