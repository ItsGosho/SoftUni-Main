package t02_user_system.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "town")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String country;
    @OneToMany
    private List<User> users;


}
