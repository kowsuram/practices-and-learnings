package io.kowsu.boot.service;

import io.kowsu.boot.dto.PersonDto;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);
    void deletePerson(PersonDto personDto);
    PersonDto updatePerson(PersonDto personDto);
    PersonDto getPerson(Integer personId);
}
