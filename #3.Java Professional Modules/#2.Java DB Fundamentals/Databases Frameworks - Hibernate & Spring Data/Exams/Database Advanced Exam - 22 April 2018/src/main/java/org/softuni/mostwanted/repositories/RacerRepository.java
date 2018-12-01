package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacerRepository extends JpaRepository<Racer,Integer> {

    Racer findRacerByName(String name);
    List<Racer> findAllByHomeTown(Town town);
}
