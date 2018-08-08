package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.persons.PersonImp;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<PersonImp> people;

    public UserRepository() {
        this.people = new ArrayList<>();
    }

    public PersonImp getByUsername(String username) {
        return this
                .getAllUsers()
                .stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<PersonImp> getAllUsers() {
        return this.people;
    }

    public void addUser(PersonImp person) {
        this.people.add(person);
    }

    public boolean userExists(String username) {
        return this.getByUsername(username) != null;
    }

    public boolean isValidCredentials(String username, String password) {
        return this.userExists(username) &&
                this.getByUsername(username).getPassword().equals(password);
    }
}
