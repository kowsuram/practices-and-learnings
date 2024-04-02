package io.kowsu.boot.service.impl;

import io.kowsu.boot.dao.PersonDao;
import io.kowsu.boot.dao.model.Person;
import io.kowsu.boot.dto.PersonDto;
import io.kowsu.boot.mapper.PersonMapper;
import io.kowsu.boot.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/*
    @created March/12/2024 - 8:02 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;
    private final PersonMapper personMapper;
    private final TransactionTemplate txTemplate;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.convertTo(personDto);
        Person personDo = personDao.save(person);
        return personMapper.convertTo(personDo);
    }

    @Override
    public void deletePerson(PersonDto personDto) {
        Person person = personMapper.convertTo(personDto);
        personDao.delete(person);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = personMapper.convertTo(personDto);
        Person personDo = personDao.save(person);
        return personMapper.convertTo(personDo);
    }

    @Override
    public PersonDto getPerson(Integer personId) {
        Optional<Person> person = personDao.findById(personId);
        if (person.isPresent()) {
            return personMapper.convertTo(person.get());
        }
        return null;
    }
}
