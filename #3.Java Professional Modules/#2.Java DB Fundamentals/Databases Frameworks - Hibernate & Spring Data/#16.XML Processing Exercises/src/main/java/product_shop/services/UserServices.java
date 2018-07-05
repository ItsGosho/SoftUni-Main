package product_shop.services;

import product_shop.models.User;

public interface UserServices {
    void saveUser(User user);
    User findUserById(int id);
}
