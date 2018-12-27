package itsgosho.domain.services;

import itsgosho.domain.entities.Supplier;
import itsgosho.domain.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServicesImp implements SupplierServices {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServicesImp(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllLocal(){
        return this.supplierRepository.findAll().stream()
                .filter(x->!x.isImporter()).collect(Collectors.toList());
    }

    @Override
    public List<Supplier> getAllmporters(){
        return this.supplierRepository.findAll().stream()
                .filter(Supplier::isImporter).collect(Collectors.toList());
    }

    @Override
    public List<Supplier> getAll(){
        return this.supplierRepository.findAll();
    }
}
