package t02_user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t02_user_system.models.Album;
import t02_user_system.repositories.AlbumRepository;
import t02_user_system.services.interfaces.AlbumSer;

@Service
@Primary
public class AlbumSerImp implements AlbumSer {
    private AlbumRepository albumRepository;

    @Autowired
    public AlbumSerImp(AlbumRepository albumRepository){
        this.albumRepository=albumRepository;
    }

    @Override
    public void saveAlbum(Album album) {
        this.albumRepository.save(album);
    }
}
