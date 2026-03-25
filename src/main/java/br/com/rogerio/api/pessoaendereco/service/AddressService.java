package br.com.rogerio.api.pessoaendereco.service;

import br.com.rogerio.api.pessoaendereco.database.model.Address;
import br.com.rogerio.api.pessoaendereco.database.model.Person;
import br.com.rogerio.api.pessoaendereco.database.repository.AddressRepository;
import br.com.rogerio.api.pessoaendereco.database.repository.PersonRepository;
import br.com.rogerio.api.pessoaendereco.exception.BusinessException;
import br.com.rogerio.api.pessoaendereco.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public AddressService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address save(Integer pessoaId, Address address) {
        Person person = personRepository.findById(pessoaId)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

        address.setPerson(person);

        // Se for marcado como principal, desmarca os outros
        if (Boolean.TRUE.equals(address.getPrimaryAddress())) {
            person.getAddresses().forEach(a -> a.setPrimaryAddress(false));
        }

        return addressRepository.save(address);
    }

    @Transactional
    public Address update(Integer pessoaId, Integer enderecoId, Address addressData) {
        Person person = personRepository.findById(pessoaId)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));

        Address address = addressRepository.findById(enderecoId)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));

        if (!address.getPerson().getId().equals(pessoaId)) {
            throw new BusinessException("Endereço não pertence à pessoa informada");
        }

        address.setStreet(addressData.getStreet());
        address.setNumber(addressData.getNumber());
        address.setComplement(addressData.getComplement());
        address.setNeighborhood(addressData.getNeighborhood());
        address.setCity(addressData.getCity());
        address.setState(addressData.getState());
        address.setZipCode(addressData.getZipCode());

        // Se for marcado como principal, desmarca os outros
        if (Boolean.TRUE.equals(addressData.getPrimaryAddress())) {
            person.getAddresses().forEach(a -> a.setPrimaryAddress(false));
            address.setPrimaryAddress(true);
        } else {
            address.setPrimaryAddress(addressData.getPrimaryAddress());
        }

        return addressRepository.save(address);
    }

    @Transactional
    public void delete(Integer pessoaId, Integer enderecoId) {
        Address address = addressRepository.findById(enderecoId)
                .orElseThrow(() -> new NotFoundException("Endereço não encontrado"));

        if (!address.getPerson().getId().equals(pessoaId)) {
            throw new BusinessException("Endereço não pertence à pessoa informada");
        }

        addressRepository.delete(address);
    }
}
