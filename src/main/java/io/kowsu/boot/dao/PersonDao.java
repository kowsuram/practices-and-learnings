package io.kowsu.boot.dao;

import io.kowsu.boot.dao.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {
}
