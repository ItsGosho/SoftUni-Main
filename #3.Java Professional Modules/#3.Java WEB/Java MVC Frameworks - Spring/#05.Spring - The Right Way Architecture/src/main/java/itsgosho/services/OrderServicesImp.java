package itsgosho.services;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.Order;
import itsgosho.domain.entities.User;
import itsgosho.domain.models.view.AllOrdersViewDto;
import itsgosho.repositories.EventRepository;
import itsgosho.repositories.OrderRepository;
import itsgosho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServicesImp implements OrderServices {

    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServicesImp(OrderRepository orderRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Integer getTotalBoughtTickets(Event event) {
        return this.orderRepository.findAllByEvent(event).stream().mapToInt(Order::getTicketsCount).sum();
    }


    public boolean makeOrder(String eventId, Integer ticketsCount, String username) {

        Event event = this.eventRepository.findById(eventId).orElse(null);
        User user = this.userRepository.findUserByUsername(username);

        if (event != null && ticketsCount >= 1 && user != null) {
            Order order = new Order();
            order.setEvent(event);
            order.setTicketsCount(ticketsCount);
            order.setCustomer(user);
            order.setOrderedOn(LocalDateTime.now());

            this.orderRepository.save(order);
            return true;
        }

        return false;
    }

    @Override
    public List<AllOrdersViewDto> findAll() {
        List<AllOrdersViewDto> result = new LinkedList<>();

        this.orderRepository.findAll().forEach(x -> {
            AllOrdersViewDto allOrdersViewDto = new AllOrdersViewDto();

            allOrdersViewDto.setEventName(x.getEvent().getName());
            allOrdersViewDto.setCustomerName(x.getCustomer().getFirstName());
            allOrdersViewDto.setOrderedOn(x.getOrderedOn());

            result.add(allOrdersViewDto);
        });
        return result;
    }
}
