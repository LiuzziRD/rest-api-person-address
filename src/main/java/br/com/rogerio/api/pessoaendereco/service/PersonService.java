package br.com.rogerio.api.pessoaendereco.service;

import br.com.rogerio.api.pessoaendereco.database.model.Person;
import br.com.rogerio.api.pessoaendereco.database.repository.PersonRepository;
import br.com.rogerio.api.pessoaendereco.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    public Person update(Integer id, Person personData) {
        Person person = findById(id);
        person.setName(personData.getName());
        person.setCpf(personData.getCpf());
        person.setEmail(personData.getEmail());
        person.setBirthDate(personData.getBirthDate());
        person.setPhones(personData.getPhones());
        return repository.save(person);
    }

    public void delete(Integer id) {
        Person person = findById(id);
        repository.delete(person);
    }
}
