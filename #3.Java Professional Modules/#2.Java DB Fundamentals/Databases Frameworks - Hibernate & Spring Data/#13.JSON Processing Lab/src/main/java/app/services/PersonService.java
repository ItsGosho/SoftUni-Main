package app.services;

import app.models.Person;

import java.util.List;

public interface PersonService {
    void create(Person person);

    Person findById(long id);

    List<Person> findByCountry(String country);
}
