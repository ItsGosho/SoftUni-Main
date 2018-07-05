package app.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean isAdministrator;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Game> games;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        //Matcher matcher=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*,_+<>?])[A-Za-z\\d!@#$%^&*,_+<>?]{1,}").matcher(password);

            this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        //Matcher matcher=Pattern.compile("([A-Za-z0-9]){1,}([A-Za-z0-9\\.\\-\\_])([A-Za-z0-9]){1,}(\\@)([A-Za-z]+)(\\.)([A-Za-z]+)").matcher(email);
            this.email = email;
    }
    public boolean isAdministrator() {
        return isAdministrator;
    }
    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
    public Set<Game> getGames() {
        if(isAdministrator){
            return games;
        }else{
            throw new IllegalArgumentException("You are not administrator!");
        }
    }
    public void setGames(Set<Game> games) {
        if(isAdministrator){
            this.games=games;
        }else{
            throw new IllegalArgumentException("You are not administrator!");
        }
    }
}
