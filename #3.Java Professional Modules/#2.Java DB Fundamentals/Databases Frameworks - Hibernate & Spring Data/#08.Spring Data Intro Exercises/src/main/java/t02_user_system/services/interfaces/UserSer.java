package t02_user_system.services.interfaces;

import t02_user_system.models.User;

import java.util.Date;
import java.util.List;

public interface UserSer {
    void saveUser(User user);
    List<User> findUsersByEmailEquals(String email);
    void setDeleteForInnactiveUsersAfterDate(Date date);
}
