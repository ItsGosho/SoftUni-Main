package itsgosho.controllers;

import itsgosho.domain.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sales")
public class SalesController extends BaseController {

    private final SaleServices saleServices;

    @Autowired
    public SalesController(SaleServices saleServices) {
        this.saleServices = saleServices;
    }

    @GetMapping("")
    public ModelAndView all(ModelAndView modelAndView){
        modelAndView.addObject("sales",this.saleServices.getAllSales());
        return super.view("sales/allSales",modelAndView);
    }
}
