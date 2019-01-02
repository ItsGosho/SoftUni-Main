package itsgosho.repositories;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {

    @Query("SELECT distinct e.name, (\n" +
            "SELECT SUM(Jo.ticketsCount)\n" +
            "FROM Order AS Jo\n" +
            "WHERE Jo.event = e AND Jo.customer=?1\n" +
            ") AS totalTickets , e\n" +
            "FROM Order AS o\n" +
            "JOIN Event AS e ON e = o.event\n" +
            "where o.customer = ?1")
    List<Object> getUserEvents(User user);

    Event findEventByName(String name);
}
