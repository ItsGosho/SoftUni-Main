package itsgosho.services;

import itsgosho.domain.entities.User;
import itsgosho.domain.models.dtos.EventCreateDto;
import itsgosho.domain.models.view.AllEventsViewDto;
import itsgosho.domain.models.view.MyEventsViewDto;

import java.util.List;
import java.util.Set;

public interface EventServices {

    boolean create(EventCreateDto eventCreateDto);

    List<AllEventsViewDto> getAllAvailable();

    List<MyEventsViewDto> getUserEvents(User user);
}
