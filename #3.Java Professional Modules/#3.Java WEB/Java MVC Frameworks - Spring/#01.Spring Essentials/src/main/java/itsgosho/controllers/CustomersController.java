package itsgosho.controllers;

import itsgosho.domain.dtos.AddCustomerDto;
import itsgosho.domain.entities.Customer;
import itsgosho.domain.services.CustomerServices;
import itsgosho.domain.services.CustomerServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomersController extends BaseController {

    private final CustomerServices customerServices;

    @Autowired
    public CustomersController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping("")
    public ModelAndView all(ModelAndView modelAndView) {
        modelAndView.addObject("customers", this.customerServices.getAll());
        return super.view("customers/allCustomers", modelAndView);
    }

    @GetMapping("/all/ascending")
    public ModelAndView allAscending(ModelAndView modelAndView) {
        modelAndView.addObject("customers", this.customerServices.getAllByBirthdateAscending());
        return super.view("customers/allCustomers", modelAndView);
    }

    @GetMapping("/all/descending")
    public ModelAndView allDescending(ModelAndView modelAndView) {
        modelAndView.addObject("customers", this.customerServices.getAllByBirthdateDescending());
        return super.view("customers/allCustomers", modelAndView);
    }

    @GetMapping("/create")
    public ModelAndView createGet(ModelAndView modelAndView) {
        return super.view("customers/addCustomerForm");
    }

    @PostMapping("/create")
    public ModelAndView createPost(ModelAndView modelAndView, AddCustomerDto addCustomerDto) {
        if(this.customerServices.create(addCustomerDto)){
            return super.redirect("/customers");
        }
        return super.redirect("/customers/create");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editGet(ModelAndView modelAndView, @PathVariable Integer id) {
        Customer customer = this.customerServices.getById(id);
        modelAndView.addObject("name",customer.getName());
        return super.view("customers/editCustomerForm",modelAndView);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editPost(ModelAndView modelAndView, @PathVariable Integer id,AddCustomerDto addCustomerDto) {
        if(this.customerServices.edit(id,addCustomerDto)){
            return super.redirect("/customers");
        }
        return super.redirect("/customers/editCustomerForm");
    }
}
