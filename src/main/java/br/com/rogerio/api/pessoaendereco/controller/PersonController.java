package br.com.rogerio.api.pessoaendereco.controller;

import br.com.rogerio.api.pessoaendereco.DTO.PersonDto;
import br.com.rogerio.api.pessoaendereco.DTO.PersonMapper;
import br.com.rogerio.api.pessoaendereco.database.model.Person;
import br.com.rogerio.api.pessoaendereco.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto dto) {
        Person saved = service.save(PersonMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonMapper.toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        List<PersonDto> people = service.findAll()
                .stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Integer id) {
        Person person = service.findById(id);
        return ResponseEntity.ok(PersonMapper.toDTO(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Integer id, @Valid @RequestBody PersonDto dto) {
        Person updated = service.update(id, PersonMapper.toEntity(dto));
        return ResponseEntity.ok(PersonMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
