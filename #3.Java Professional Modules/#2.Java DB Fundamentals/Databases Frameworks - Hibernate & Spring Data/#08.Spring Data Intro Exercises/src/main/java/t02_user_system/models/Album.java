package t02_user_system.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String backgroundColor;
    private boolean isPublic;

    @OneToMany
    private List<Picture> pictures;
}
