package itsgosho.domain.services;

import itsgosho.domain.entities.Part;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PartServices {

    List<Part> getAll();
}
