package itsgosho.repositories;

import itsgosho.domain.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchRepository extends JpaRepository<Watch,String> {

    @Query("SELECT w\n" +
            "FROM Watch w\n" +
            "ORDER BY w.views DESC")
    List<Watch> findAllOrderedByViews();
}
