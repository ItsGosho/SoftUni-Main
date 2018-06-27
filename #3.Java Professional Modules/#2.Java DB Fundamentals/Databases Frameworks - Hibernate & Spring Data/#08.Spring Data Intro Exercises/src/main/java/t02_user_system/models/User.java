package t02_user_system.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "user")
public class User {

    // **** HIBERNATE VALIDATOR :@

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(unique = false,nullable = false)
    private String firstName;

    @Column(unique = false,nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    //@Length(min=4,max=30,message = "Username length is not in the allowed size")
    private String username;

    @Column(nullable = false)
    //@Length(min=6,max=50,message = "Password length is not in the allowed size")
    private String password;

    @Column(nullable = false)
    private String email;

    @Lob
    //@Size(max = 1024*1024)
    private byte[] profilePicture;
    private Date registeredOn;
    private Date lastTimeLoggedIn;

    //@Size(min=1 ,max=120)
    private int age;
    private boolean isDeleted;

    @ManyToMany
    private List<User> friends;

    @OneToMany
    private List<Album> albums;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        Matcher matcher=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*,_+<>?])[A-Za-z\\d!@#$%^&*,_+<>?]{1,}").matcher(password);

        if(matcher.find()){
            this.password = password;
        }else{
            throw new IllegalArgumentException("PASSWORD NOT COVER THE REQUIPMENTS");
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        Matcher matcher=Pattern.compile("([A-Za-z0-9]){1,}([A-Za-z0-9\\.\\-\\_])([A-Za-z0-9]){1,}(\\@)([A-Za-z]+)(\\.)([A-Za-z]+)").matcher(email);
        if(matcher.find()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Email is not in the reuired valid format! :)");
        }
    }
    public byte[] getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
    public Date getRegisteredOn() {
        return registeredOn;
    }
    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }
    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }
    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName(){
        return this.getFirstName()+" "+this.getLastName();
    }
    public List<User> getFriends() {
        return friends;
    }
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
