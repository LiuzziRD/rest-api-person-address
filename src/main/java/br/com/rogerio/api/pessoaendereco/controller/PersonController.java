package br.com.rogerio.api.pessoaendereco.controller;

import br.com.rogerio.api.pessoaendereco.DTO.PersonDto;
import br.com.rogerio.api.pessoaendereco.DTO.PersonMapper;
import br.com.rogerio.api.pessoaendereco.database.model.Person;
import br.com.rogerio.api.pessoaendereco.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public PersonDto save(@RequestBody Person person) {
        Person saved = service.save(person);
        return PersonMapper.toDTO(saved);
    }

    @GetMapping
    public List<PersonDto> findAll() {
        return service.findAll()
                .stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Integer id) {
        Person person = service.findById(id);
        return PersonMapper.toDTO(person);
    }

    @PutMapping("/{id}")
    public PersonDto update(@PathVariable Integer id, @RequestBody Person person) {
        Person updated = service.update(id, person);
        return PersonMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
