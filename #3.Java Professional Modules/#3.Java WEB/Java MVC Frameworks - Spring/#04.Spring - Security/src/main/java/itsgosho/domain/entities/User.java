package itsgosho.domain.entities;

import itsgosho.domain.enumarations.UserRoles;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enable")
    private boolean isEnabled;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<UserRole> authorities;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    public User(){
        this.setAuthorities(new HashSet<>());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(Set<UserRole> authorities) {
        this.authorities = authorities;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


    //return the highest role EXAMPLE: Set<USER...MODERATOR...ADMIN> result ADMIN
    public String getRole(){
        String role = this.getAuthorities()
                .stream().min((x1, x2) -> Integer.compare(UserRoles.valueOf(((GrantedAuthority) x2).getAuthority()).ordinal(), UserRoles.valueOf(((GrantedAuthority) x1).getAuthority()).ordinal()))
                .get().getAuthority();
        return role;
    }

    public String getNextRole(){

        int ord = UserRoles.valueOf(getRole()).ordinal()+1;
        if(hasNextRole()){
            return UserRoles.values()[ord].name();
        }

        return "";
    }

    public String getLowerRole(){

        int ord = UserRoles.valueOf(getRole()).ordinal()-1;
        if(hasLowerRole()){
            return UserRoles.values()[ord].name();
        }

        return "";
    }

    public boolean hasNextRole(){
        int maxOrd = UserRoles.valueOf("ROOT_ADMIN").ordinal();
        int ord = UserRoles.valueOf(getRole()).ordinal();

        if(ord<maxOrd-1){
            return true;
        }
        return false;
    }

    public boolean hasLowerRole(){
        if(this.authorities.size()!=1){
             return true;
        }
        return false;
    }

    public void addAuthority(UserRole userRole){
        this.authorities.add(userRole);
    }
}
