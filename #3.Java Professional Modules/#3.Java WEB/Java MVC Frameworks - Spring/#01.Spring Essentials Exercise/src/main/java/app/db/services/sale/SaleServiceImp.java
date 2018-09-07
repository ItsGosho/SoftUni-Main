package app.db.services.sale;

import app.db.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImp implements SaleService{

    @Autowired
    private SaleRepository saleRepository;

}
