package itsgosho.domain.utils;

import itsgosho.domain.entities.UserRole;
import itsgosho.domain.enumarations.UserRoles;
import itsgosho.domain.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleUtil {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleUtil(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole bakeRole(UserRoles userRoles){
        String authority = userRoles.name();
        UserRole userRole = this.userRoleRepository.findUserRoleByAuthority(authority);

        if(userRole==null){
            userRole = new UserRole();
            userRole.setAuthority(authority);
            this.userRoleRepository.saveAndFlush(userRole);
        }
        return userRole;
    }

    public UserRole getRole(String roleName){
        return this.userRoleRepository.findUserRoleByAuthority(roleName.toUpperCase());
    }
}
