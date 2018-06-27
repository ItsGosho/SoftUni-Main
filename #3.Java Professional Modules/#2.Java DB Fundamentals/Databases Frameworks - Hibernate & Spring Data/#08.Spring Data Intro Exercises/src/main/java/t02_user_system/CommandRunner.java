package t02_user_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import t02_user_system.models.User;
import t02_user_system.services.AlbumSerImp;
import t02_user_system.services.PictureSerImp;
import t02_user_system.services.TownSerImp;
import t02_user_system.services.UserSerImp;

import java.util.Date;

@SpringBootApplication
@Component
public class CommandRunner implements CommandLineRunner {
    private UserSerImp userSerImp;
    private TownSerImp townSerImp;
    private PictureSerImp pictureSerImp;
    private AlbumSerImp albumSerImp;

    @Autowired
    public CommandRunner(UserSerImp userSerImp, TownSerImp townSerImp, PictureSerImp pictureSerImp, AlbumSerImp albumSerImp) {
        this.userSerImp = userSerImp;
        this.townSerImp = townSerImp;
        this.pictureSerImp = pictureSerImp;
        this.albumSerImp = albumSerImp;
    }

    @Override
    public void run(String... strings) throws Exception {
        /*User user = new User();
        user.setAge(17);
        user.setDeleted(false);
        user.setEmail("joro@gmail.com");
        user.setFirstName("Georgi");
        user.setLastName("Peev");
        user.setUsername("itsgosho");
        user.setPassword("Gg1$");
        user.setProfilePicture(new byte[]{1,2,3,4});
        user.setLastTimeLoggedIn(new Date(2015,1,1));
        user.setRegisteredOn(new Date(1993,1,1));

        this.userSerImp.saveUser(user);*/


        //this.userSerImp.setDeleteForInnactiveUsersAfterDate(new Date(1993,1,1));
        this.userSerImp.findUsersByEmailEquals("joro@gmail.com")
        .forEach(x->{
            System.out.println(x.getId()+" "+x.getFirstName());
        });
    }
}
