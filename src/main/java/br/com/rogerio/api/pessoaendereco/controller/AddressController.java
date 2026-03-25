package br.com.rogerio.api.pessoaendereco.controller;

import br.com.rogerio.api.pessoaendereco.DTO.AddressDto;
import br.com.rogerio.api.pessoaendereco.DTO.AddressMapper;
import br.com.rogerio.api.pessoaendereco.database.model.Address;
import br.com.rogerio.api.pessoaendereco.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas/{pessoaId}/enderecos")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    public AddressDto save(@PathVariable Integer pessoaId, @RequestBody Address address) {
        Address saved = service.save(pessoaId, address);
        return AddressMapper.toDTO(saved);
    }

    @PutMapping("/{enderecoId}")
    public AddressDto update(@PathVariable Integer pessoaId,
                             @PathVariable Integer enderecoId,
                             @RequestBody Address address) {
        Address updated = service.update(pessoaId, enderecoId, address);
        return AddressMapper.toDTO(updated);
    }

    @DeleteMapping("/{enderecoId}")
    public void delete(@PathVariable Integer pessoaId,
                       @PathVariable Integer enderecoId) {
        service.delete(pessoaId, enderecoId);
    }
}
