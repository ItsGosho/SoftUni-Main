package itsgosho.services.role;

import itsgosho.domain.entities.User;
import itsgosho.domain.entities.UserRole;
import itsgosho.domain.enumerations.UserRoles;
import itsgosho.repositories.UserRoleRepository;
import itsgosho.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRoleServicesImp implements UserRoleServices {

    private final UserRoleRepository userRoleRepository;
    private final UserServices userServices;

    @Autowired
    public UserRoleServicesImp(UserRoleRepository userRoleRepository, UserServices userServices) {
        this.userRoleRepository = userRoleRepository;
        this.userServices = userServices;
    }

    @Override
    public UserRole create(UserRoles userRoles){

        UserRole userRole = new UserRole();
        if(this.isExists(userRoles.name())){
            return this.userRoleRepository.findUserRoleByAuthority(userRoles.name().toUpperCase());
        }
        userRole.setAuthority(userRoles.name().toUpperCase());
        this.userRoleRepository.save(userRole);
        return userRole;
    }


    @Override
    public User initialSetAuthorities(User user){

        List<UserRole> userRoles = new LinkedList<>();
        userRoles.add(this.create(UserRoles.USER));
        if(this.userServices.findAll().size()==0){
            userRoles.add(this.create(UserRoles.ADMIN));
        }

        user.setAuthorities(userRoles);

        return user;
    }

    private boolean isExists(String roleName){
        return this.userRoleRepository.findUserRoleByAuthority(roleName)!=null;
    }

    //Finds the highest user role based on UserRoles Enumeration
    @Override
    public String getRole(User user){
        Optional<? extends GrantedAuthority> role = user.getAuthorities().stream().min(Comparator.comparingInt(x -> UserRoles.valueOf(((GrantedAuthority) x).getAuthority().toUpperCase()).ordinal()).reversed());
        return role.get().getAuthority();
    }

}
