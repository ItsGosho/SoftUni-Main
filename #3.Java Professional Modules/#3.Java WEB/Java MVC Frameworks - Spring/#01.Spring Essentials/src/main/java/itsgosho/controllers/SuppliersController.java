package itsgosho.controllers;

import itsgosho.domain.services.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController extends BaseController{

   private final SupplierServices supplierServices;

    @Autowired
    public SuppliersController(SupplierServices supplierServices) {
        this.supplierServices = supplierServices;
    }

    @GetMapping("")
    public ModelAndView all(ModelAndView modelAndView){
        modelAndView.addObject("suppliers",this.supplierServices.getAll());
        return super.view("suppliers/allSuppliers.html",modelAndView);
    }

    @GetMapping("/local")
    public ModelAndView local(ModelAndView modelAndView){
        modelAndView.addObject("suppliers",this.supplierServices.getAllLocal());
        return super.view("suppliers/allSuppliers.html",modelAndView);
    }


    @GetMapping("/importers")
    public ModelAndView importers(ModelAndView modelAndView){
        modelAndView.addObject("suppliers",this.supplierServices.getAllmporters());
        return super.view("suppliers/allSuppliers.html",modelAndView);
    }
}
