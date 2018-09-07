package app.db.services.part;

import app.db.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImp implements PartService{

    @Autowired
    private PartRepository partRepository;
}
