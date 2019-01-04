package itsgosho.controllers;

import itsgosho.domain.entities.User;
import itsgosho.domain.models.dtos.EventCreateDto;
import itsgosho.services.event.EventServices;
import itsgosho.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/events")
public class EventController extends BaseController {

    private final EventServices eventServices;
    private final UserServices userServices;

    @Autowired
    public EventController(EventServices eventServices, UserServices userServices) {
        this.eventServices = eventServices;
        this.userServices = userServices;
    }

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView viewCreateEvent(){
        return super.page("main-page","pages/events/create-event","Create Event");
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView createEvent(@Valid EventCreateDto eventCreateDto, BindingResult bindingResult){
        if(!bindingResult.hasErrors() && this.eventServices.create(eventCreateDto)){
            return super.redirect("/events/all");
        }

        return super.page("main-page","pages/events/create-event","Create Event");
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('USER')")
    public ModelAndView viewAllEvents(ModelAndView modelAndView){
        modelAndView.addObject("events",this.eventServices.getAllAvailable());
        return super.page("main-page","pages/events/all-events","All Events",modelAndView);
    }

    @GetMapping("/my")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView myEvents(ModelAndView modelAndView, Principal principal) {

        modelAndView.addObject("events",this.eventServices.getUserEvents((User) this.userServices.loadUserByUsername(principal.getName())));

        return super.page("main-page","pages/events/my-events","My Events",modelAndView);
    }
}
