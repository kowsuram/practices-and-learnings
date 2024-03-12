package io.kowsu.controller;

/*
    @created March/12/2024 - 8:17 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

import io.kowsu.boot.dto.PersonDto;
import io.kowsu.boot.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto).toString();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public String updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto).toString();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String removePerson(@RequestBody PersonDto personDto) {
        personService.deletePerson(personDto);
        return "Deleted";
    }

    @Cacheable(value = "persons", key = "#id")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public PersonDto getPerson(@PathVariable("id") Integer id) {
        return personService.getPerson(id);
    }

}
