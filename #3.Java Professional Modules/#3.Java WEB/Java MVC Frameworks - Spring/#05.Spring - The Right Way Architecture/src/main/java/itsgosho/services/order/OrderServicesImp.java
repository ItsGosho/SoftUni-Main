package itsgosho.services.order;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.Order;
import itsgosho.domain.entities.User;
import itsgosho.domain.models.view.AllOrdersViewDto;
import itsgosho.repositories.OrderRepository;
import itsgosho.services.user.UserServices;
import itsgosho.services.event.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderServicesImp implements OrderServices {

    private final OrderRepository orderRepository;
    private final EventServices eventServices;
    private final UserServices userServices;

    @Autowired
    public OrderServicesImp(OrderRepository orderRepository, EventServices eventServices, UserServices userServices) {
        this.orderRepository = orderRepository;
        this.eventServices = eventServices;
        this.userServices = userServices;
    }


    @Override
    public Integer getTotalBoughtTickets(Event event) {
        return this.orderRepository.findAllByEvent(event).stream().mapToInt(Order::getTicketsCount).sum();
    }


    public boolean makeOrder(String eventId, Integer ticketsCount, String username) {

        Event event = this.eventServices.findById(eventId);
        User user = (User) this.userServices.loadUserByUsername(username);

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
