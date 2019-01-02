package itsgosho.services;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.User;
import itsgosho.domain.models.view.AllOrdersViewDto;

import javax.jms.JMSException;
import java.util.List;

public interface OrderServices {
    Integer getTotalBoughtTickets(Event event);

    boolean makeOrder(String eventId,Integer ticketsCount, String username);

    List<AllOrdersViewDto> findAll();
}
