package app.exam.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",unique = true,nullable = false)
    @Length(min = 3,max = 30)
    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
