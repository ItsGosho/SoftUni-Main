package itsgosho.controllers;

import itsgosho.services.order.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController extends BaseController {

    private final OrderServices orderServices;

    @Autowired
    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @PostMapping("/make/{eventId}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView makeOrder(@PathVariable String eventId, @RequestParam Integer ticketsCount, Principal principal) {
        if (this.orderServices.makeOrder(eventId, ticketsCount, principal.getName())) {
            return super.redirect("/events/my");
        }

        return super.redirect("/events/all");
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView allOrders(ModelAndView modelAndView) {
        modelAndView.addObject("orders",this.orderServices.findAll());
        return super.page("main-page","pages/orders/all-orders","All Orders",modelAndView);
    }
}
