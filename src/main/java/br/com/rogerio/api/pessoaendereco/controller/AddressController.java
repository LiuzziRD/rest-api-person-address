package br.com.rogerio.api.pessoaendereco.controller;

import br.com.rogerio.api.pessoaendereco.DTO.AddressDto;
import br.com.rogerio.api.pessoaendereco.DTO.AddressMapper;
import br.com.rogerio.api.pessoaendereco.database.model.Address;
import br.com.rogerio.api.pessoaendereco.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas/{pessoaId}/enderecos")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AddressDto> save(@PathVariable Integer pessoaId,
                                           @Valid @RequestBody AddressDto dto) {
        Address saved = service.save(pessoaId, AddressMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(AddressMapper.toDTO(saved));
    }

    @PutMapping("/{enderecoId}")
    public ResponseEntity<AddressDto> update(@PathVariable Integer pessoaId,
                                             @PathVariable Integer enderecoId,
                                             @Valid @RequestBody AddressDto dto) {
        Address updated = service.update(pessoaId, enderecoId, AddressMapper.toEntity(dto));
        return ResponseEntity.ok(AddressMapper.toDTO(updated));
    }

    @DeleteMapping("/{enderecoId}")
    public ResponseEntity<Void> delete(@PathVariable Integer pessoaId,
                                       @PathVariable Integer enderecoId) {
        service.delete(pessoaId, enderecoId);
        return ResponseEntity.noContent().build();
    }
}
