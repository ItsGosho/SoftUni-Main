package t02_user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t02_user_system.models.Picture;
import t02_user_system.repositories.PictureRepository;
import t02_user_system.services.interfaces.PictureSer;

@Service
@Primary
public class PictureSerImp implements PictureSer {
    private PictureRepository pictureRepository;

    @Autowired
    public PictureSerImp(PictureRepository pictureRepository){
        this.pictureRepository=pictureRepository;
    }

    @Override
    public void savePicture(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
