package app.services;

import app.entities.User;

public interface UserServices {
    void saveUser(User user);
    User findUserByEmailEquals(String email);
}
