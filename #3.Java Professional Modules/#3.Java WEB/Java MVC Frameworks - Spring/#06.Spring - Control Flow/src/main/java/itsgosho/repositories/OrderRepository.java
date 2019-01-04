package itsgosho.repositories;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    Set<Order> findAllByEvent(Event event);
}
