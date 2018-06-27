package t02_user_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t02_user_system.models.Album;

public interface AlbumRepository extends CrudRepository<Album,Integer> {
}
