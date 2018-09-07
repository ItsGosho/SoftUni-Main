package app.controllers.query;

import app.controllers.BaseController;
import app.db.entities.Supplier;
import app.db.repositories.PartRepository;
import app.db.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QueryThirdController extends BaseController {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private PartRepository partRepository;

    @GetMapping("/suppliers/local")
    @ResponseBody
    public String local(){
        StringBuilder str=new StringBuilder();
        for (Supplier supplier : this.supplierRepository.getSuppliersByIsImporter(false)) {
            final long[] countSupp = {0};
                    this.partRepository.getPartsBySupplier(supplier).forEach(x->{
                countSupp[0] =+x.getQuantity();
            });
            str.append("<h1>"+supplier.getId()+" "+supplier.getName()+" "+countSupp[0]+"</h1>");
        }
        return str.toString();
    }

    @GetMapping("/suppliers/importers")
    @ResponseBody
    public String importers(){
        StringBuilder str=new StringBuilder();
        for (Supplier supplier : this.supplierRepository.getSuppliersByIsImporter(true)) {
            final long[] countSupp = {0};
            this.partRepository.getPartsBySupplier(supplier).forEach(x->{
                countSupp[0] =+x.getQuantity();
            });
            str.append("<h1>"+supplier.getId()+" "+supplier.getName()+" "+countSupp[0]+"</h1>");
        }
        return str.toString();
    }
}
