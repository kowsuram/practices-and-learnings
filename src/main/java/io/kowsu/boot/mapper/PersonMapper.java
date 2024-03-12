package io.kowsu.boot.mapper;

/*
    @created March/12/2024 - 8:21 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/


import io.kowsu.boot.dao.model.Person;
import io.kowsu.boot.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person convertTo(PersonDto personDto);
    PersonDto convertTo(Person personDto);
}
