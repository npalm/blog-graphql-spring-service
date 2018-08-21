package ofouro.code.graphql.demo.service;

import ofouro.code.graphql.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findAll();
}
