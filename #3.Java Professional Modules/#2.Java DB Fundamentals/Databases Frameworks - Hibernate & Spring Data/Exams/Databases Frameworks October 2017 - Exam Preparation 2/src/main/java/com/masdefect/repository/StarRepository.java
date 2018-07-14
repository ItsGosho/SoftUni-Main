package com.masdefect.repository;

import com.masdefect.domain.entities.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star,Integer> {

    Star findStarByName(String name);
}
