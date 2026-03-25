package br.com.rogerio.api.pessoaendereco.DTO;

import br.com.rogerio.api.pessoaendereco.database.model.Address;
import br.com.rogerio.api.pessoaendereco.database.model.Person;

import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonDto toDTO(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setCpf(person.getCpf());
        dto.setEmail(person.getEmail());
        dto.setBirthDate(person.getBirthDate());
        dto.setPhones(person.getPhones());

        if (person.getAddresses() != null) {
            dto.setAddresses(
                    person.getAddresses().stream()
                            .map(PersonMapper::toDTO)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static AddressDto toDTO(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setNumber(address.getNumber());
        dto.setComplement(address.getComplement());
        dto.setNeighborhood(address.getNeighborhood());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setZipCode(address.getZipCode());
        dto.setPrimaryAddress(address.getPrimaryAddress());
        return dto;
    }
}
