package redirections;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Redirection {

    public String redirectToIndex(){
        return Config.redirectToIndex;
    }

    public String redirectToLogin(){
        return Config.redirectToLogin;
    }

    public String redirectToRegister(){
        return Config.redirectToRegister;
    }

    public String redirectToProfile(){
        return Config.redirectToProfile;
    }
}
