package app.db.services.supplier;

import app.db.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImp implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;
}
