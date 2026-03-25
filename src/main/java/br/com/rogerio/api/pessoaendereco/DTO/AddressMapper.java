package br.com.rogerio.api.pessoaendereco.DTO;

import br.com.rogerio.api.pessoaendereco.database.model.Address;

public class AddressMapper {

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

    public static Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setComplement(dto.getComplement());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        address.setPrimaryAddress(dto.getPrimaryAddress());
        return address;
    }
}
