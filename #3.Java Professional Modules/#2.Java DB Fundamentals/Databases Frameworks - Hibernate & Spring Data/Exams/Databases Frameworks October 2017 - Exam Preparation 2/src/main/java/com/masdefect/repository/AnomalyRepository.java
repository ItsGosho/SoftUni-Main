package com.masdefect.repository;

import com.masdefect.domain.entities.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly,Integer> {

    Anomaly findAnomalyById(int id);

    List<Anomaly> getAllByOrderByIdAsc();
}
