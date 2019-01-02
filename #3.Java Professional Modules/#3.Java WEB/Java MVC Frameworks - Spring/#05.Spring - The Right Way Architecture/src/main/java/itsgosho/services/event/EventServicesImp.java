package itsgosho.services.event;

import itsgosho.domain.entities.User;
import itsgosho.domain.models.dtos.EventCreateDto;
import itsgosho.domain.entities.Event;
import itsgosho.domain.models.view.AllEventsViewDto;
import itsgosho.domain.models.view.MyEventsViewDto;
import itsgosho.repositories.EventRepository;
import itsgosho.services.order.OrderServices;
import itsgosho.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EventServicesImp implements EventServices {

    private final EventRepository eventRepository;
    private final OrderServices orderServices;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public EventServicesImp(EventRepository eventRepository, OrderServices orderServices, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;;
        this.orderServices = orderServices;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Event findById(String id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(EventCreateDto eventCreateDto) {

        if(this.validationUtil.isValid(eventCreateDto)){
            Event event = this.modelMapper.map(eventCreateDto,Event.class);
            this.eventRepository.save(event);
            return true;
        }

        return false;
    }

    @Override
    public List<AllEventsViewDto> getAllAvailable(){

        List<AllEventsViewDto> result = new LinkedList<>();

        this.eventRepository.findAll()
                .stream()
                .filter(x->!this.areTicketsFinished(x))
                .sorted((x1,x2)->x2.getStart().compareTo(x1.getStart()))
                .forEach(x->{
            AllEventsViewDto allEventsViewDto = this.modelMapper.map(x,AllEventsViewDto.class);
            int totalBoughtTickets = this.orderServices.getTotalBoughtTickets(x);
            allEventsViewDto.setRemainingTickets(x.getTotalTickets()-totalBoughtTickets);

            result.add(allEventsViewDto);
        });
        return result;
    }

    @Override
    public List<MyEventsViewDto> getUserEvents(User user) {

        List<Object> events = this.eventRepository.getUserEvents(user);
        List<MyEventsViewDto> result = new LinkedList<>();

        events.stream().forEach(x->{
            Object[] objects = (Object[]) x;
            MyEventsViewDto myEventsViewDto = this.modelMapper.map(objects[2],MyEventsViewDto.class);
            myEventsViewDto.setTotalTicketsBought(Integer.parseInt(String.valueOf(objects[1])));
            result.add(myEventsViewDto);
        });

        return result;
    }

    private boolean areTicketsFinished(Event event){
        return event.getTotalTickets()-this.orderServices.getTotalBoughtTickets(event)<=0;
    }
}
