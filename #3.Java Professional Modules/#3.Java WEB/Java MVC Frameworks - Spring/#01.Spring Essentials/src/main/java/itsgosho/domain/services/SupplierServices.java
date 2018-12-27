package itsgosho.domain.services;

import itsgosho.domain.entities.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SupplierServices {
    List<Supplier> getAllLocal();

    List<Supplier> getAllmporters();

    List<Supplier> getAll();
}
