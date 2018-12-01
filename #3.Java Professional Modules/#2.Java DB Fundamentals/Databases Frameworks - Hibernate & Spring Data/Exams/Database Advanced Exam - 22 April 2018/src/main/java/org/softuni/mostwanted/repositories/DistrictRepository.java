package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {

    District findDistinctByName(String name);
}
