package itsgosho.services.order;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.User;
import itsgosho.domain.models.view.AllOrdersViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.jms.JMSException;
import java.util.List;

public interface OrderServices {
    Integer getTotalBoughtTickets(Event event);

    boolean makeOrder(String eventId,Integer ticketsCount, String username);

    List<AllOrdersViewDto> findAll();

    Page<AllOrdersViewDto> listAllByPage(Pageable pageable);
}
