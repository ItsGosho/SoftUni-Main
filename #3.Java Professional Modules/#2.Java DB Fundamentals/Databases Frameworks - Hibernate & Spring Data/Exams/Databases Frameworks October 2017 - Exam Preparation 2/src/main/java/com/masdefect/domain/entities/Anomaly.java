package com.masdefect.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "anomaly")
public class Anomaly implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Planet originPlanet;
    @ManyToOne
    private Planet homePlanet;

    @ManyToMany
    private List<Person> victims;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Planet getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }

    public Planet getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

    public List<Person> getVictims() {
        return victims;
    }

    public void setVictims(List<Person> victims) {
        this.victims = victims;
    }
}
