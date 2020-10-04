package com.example.demo.converter;

import com.example.demo.model.dto.PersonResponseDTO;
import com.example.demo.model.entity.Person;

import java.util.function.Function;

public class PersonResponseDTOConverter
    implements Function<Person, PersonResponseDTO> {

    @Override
    public PersonResponseDTO apply(Person person) {
        final PersonResponseDTO dto = new PersonResponseDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        dto.setGenre(person.getGenre());
        dto.setGithub(person.getGithub());

        return dto;
    }
}
