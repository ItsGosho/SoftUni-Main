package app.controllers;

import app.db.dto.CreateUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class CustomerController extends BaseController{


    @GetMapping("/create/customer")
    public String getCreateCustomer(){
        return "customer/create-customer";
    }

    @PostMapping("/create/customer")
    public String postCreateCustomer(CreateUserDto createUserDto){
        Date date = new Date(createUserDto.getBirthdate());
        return "redirect:/";
    }
}
