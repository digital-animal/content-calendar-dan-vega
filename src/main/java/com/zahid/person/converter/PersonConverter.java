package com.zahid.person.converter;

import com.zahid.person.dto.PersonDto;
import com.zahid.person.model.Person;

public class PersonConverter {
    
    public static Person dtoToEntity(PersonDto dto) {
        return new Person(dto.getName(), dto.getEmail(), dto.getAddress(), dto.getGender(), dto.getProfession());
    }
    
    public static PersonDto entityToDto(Person entity) {
        return new PersonDto(entity.getName(), entity.getEmail(), entity.getAddress(), entity.getGender(), entity.getProfession());
    }
}
