package itsgosho.domain.entities;

import itsgosho.domain.enumarations.Creator;
import itsgosho.domain.enumarations.Magnitude;
import itsgosho.domain.enumarations.Mutation;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "viruses")
public class Virus {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private String id;

    private String name;

    @Lob
    private String description;

    private String sideEffects;

    @Enumerated(EnumType.STRING)
    private Creator creator;

    @Column(name = "is_deadly")
    private boolean isDeadly;
    @Column(name = "is_curable")
    private boolean isCurable;

    @Enumerated(EnumType.STRING)
    private Mutation mutation;

    private Integer turnoverRate;
    private Integer hoursUntilTurn;

    @Enumerated(EnumType.STRING)
    private Magnitude magnitude;

    private LocalDate realeseDate;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Capital> capitals;

    public Virus() {
        this.setCapitals(new LinkedList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(LocalDate realeseDate) {
        this.realeseDate = realeseDate;
    }

    public List<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
    }
}
