package itsgosho.services.event;

import itsgosho.domain.entities.Event;
import itsgosho.domain.entities.User;
import itsgosho.domain.models.dtos.EventCreateDto;
import itsgosho.domain.models.view.AllEventsViewDto;
import itsgosho.domain.models.view.MyEventsViewDto;

import java.util.List;
import java.util.Set;

public interface EventServices {

    Event findById(String id);

    boolean create(EventCreateDto eventCreateDto);

    List<AllEventsViewDto> getAllAvailable();

    List<MyEventsViewDto> getUserEvents(User user);
}
