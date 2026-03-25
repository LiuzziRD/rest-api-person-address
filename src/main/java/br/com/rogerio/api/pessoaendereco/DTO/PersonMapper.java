package br.com.rogerio.api.pessoaendereco.DTO;

import br.com.rogerio.api.pessoaendereco.database.model.Person;
import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonDto toDTO(Person entity) {
        if (entity == null) return null;
        PersonDto dto = new PersonDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setBirthDate(entity.getBirthDate());
        dto.setPhones(entity.getPhones());

        if (entity.getAddresses() != null) {
            dto.setAddresses(entity.getAddresses()
                    .stream()
                    .map(AddressMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Person toEntity(PersonDto dto) {
        if (dto == null) return null;
        Person entity = new Person();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPhones(dto.getPhones());

        if (dto.getAddresses() != null) {
            entity.setAddresses(dto.getAddresses()
                    .stream()
                    .map(AddressMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    public static void updateEntity(Person entity, PersonDto dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPhones(dto.getPhones());
    }
}
