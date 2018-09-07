package app.db.repositories;

import app.db.entities.Part;
import app.db.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {

    List<Part> getPartsBySupplier(Supplier supplier);
}
