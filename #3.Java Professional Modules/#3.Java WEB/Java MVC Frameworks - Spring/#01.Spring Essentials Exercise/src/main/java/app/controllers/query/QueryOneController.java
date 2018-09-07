package app.controllers.query;

import app.controllers.BaseController;
import app.db.entities.Customer;
import app.db.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QueryOneController extends BaseController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/all/ascending")
    @ResponseBody
    public String ascending(){

        StringBuilder str=new StringBuilder();
        for (Customer customer : getOrdered("ascending")) {
            str.append("<h1>"+customer.getId()+" "+customer.getName()+" "+customer.getBirthDate()+"</h1>");
        }
        return str.toString();
    }

    @GetMapping("/customers/all/descending")
    @ResponseBody
    public String descending(){

        StringBuilder str=new StringBuilder();
        for (Customer customer : getOrdered("descending")) {
            str.append("<h1>"+customer.getId()+" "+customer.getName()+" "+customer.getBirthDate()+"</h1>");
        }
        return str.toString();
    }

    private List<Customer> getOrdered(String orderType){
        List<Customer> customs = this.customerRepository.findAll();
        if(orderType.toLowerCase().equals("ascending")){
            return customs.stream().sorted((x1,x2)->x1.getBirthDate().compareTo(x2.getBirthDate()))
                    .collect(Collectors.toList());
        }else if(orderType.toLowerCase().equals("descending")){
           return customs.stream().sorted((x1,x2)->x2.getBirthDate().compareTo(x1.getBirthDate()))
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }
}
