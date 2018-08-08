package org.softuni.fdmc.data.models.persons;

public abstract class PersonImp implements Person{
    private String username;

    private String password;

    public PersonImp(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public PersonImp() {
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
      this.username=username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
           this.password=password;
    }
}
