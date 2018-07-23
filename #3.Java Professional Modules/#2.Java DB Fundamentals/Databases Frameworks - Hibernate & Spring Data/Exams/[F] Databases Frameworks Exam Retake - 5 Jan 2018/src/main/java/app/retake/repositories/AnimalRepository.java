package app.retake.repositories;

import app.retake.domain.models.Animal;
import app.retake.domain.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    Animal getAnimalByPassport(Passport passport);

    List<Animal> getAnimalsByPassportOwnerPhoneNumber(String phoneNumber);
}
