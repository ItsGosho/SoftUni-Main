package itsgosho.services;

import itsgosho.domain.entities.User;
import itsgosho.domain.entities.UserRole;
import itsgosho.domain.enumerations.UserRoles;

public interface UserRoleServices {

    //Create the role if not exist and returns it otherwise if exist
    //return the already saved role
    UserRole create(UserRoles userRoles);

    //Used when the user doesn't have roles yet
    //!The first registered user is the admin!
    User initialSetAuthorities(User user);

    String getRole(User user);
}
