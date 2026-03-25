package br.com.rogerio.api.pessoaendereco.service;

import br.com.rogerio.api.pessoaendereco.database.model.Address;
import br.com.rogerio.api.pessoaendereco.database.repository.AddressRepository;
import br.com.rogerio.api.pessoaendereco.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address not found."));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
