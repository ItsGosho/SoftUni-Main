package itsgosho.domain.services;

import itsgosho.domain.entities.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SaleServices {
    List<Sale> getAllSales();
}
