package mostwanted.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int default 0",nullable = false)
    private Integer laps;

    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    private District district;

    @OneToMany
    @JoinColumn(name = "race_id",referencedColumnName = "id")
    private Set<RaceEntry> entries;

    public Race() {
        this.setEntries(new HashSet<>());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Set<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntry> entries) {
        this.entries = entries;
    }
}
