package t02_user_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t02_user_system.models.Picture;

public interface PictureRepository extends CrudRepository<Picture,Integer> {
}
