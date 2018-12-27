package itsgosho.domain.services;

import itsgosho.domain.entities.Sale;
import itsgosho.domain.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServicesImp implements SaleServices {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServicesImp(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> getAllSales(){
        return this.saleRepository.findAll();
    }
}
