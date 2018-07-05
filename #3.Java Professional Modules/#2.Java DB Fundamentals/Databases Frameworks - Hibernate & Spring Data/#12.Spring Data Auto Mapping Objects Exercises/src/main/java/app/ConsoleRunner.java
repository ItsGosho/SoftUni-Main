package app;

import app.entities.Game;
import app.entities.User;
import app.repository.GameRepository;
import app.repository.UserRepository;
import app.services.GameServices;
import app.services.UserServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private GameServices gameServices;
    private UserServices userServices;
    private static User loggedUser;

    @Autowired
    public ConsoleRunner(GameServices gameServices, UserServices userServices) {
        this.gameServices = gameServices;
        this.userServices = userServices;
    }

    @Override
    public void run(String... args) throws Exception {
        loggedUser=this.userServices.findUserByEmailEquals("ivan@ivan.com");
       viewGame("OwnedGame");
    }

    public void registerUser(String registerLine){
        String[] splitted=registerLine.split("\\|");
        User user=new User();
        user.setEmail(splitted[1]);
        String password=splitted[2];
        String confirmPassword=splitted[3];
        if(password.equals(confirmPassword)){
            user.setPassword(password);
            user.setFullName(splitted[4]);
            this.userServices.saveUser(user);
            System.out.println(splitted[4]+" was registered");
        }else{
            System.out.println("Password doesnt match");
        }
    }
    public void loginUser(String loginLine){
        String[] splitted=loginLine.split("\\|");
        String email=splitted[1];
        String password=splitted[2];
        User user=this.userServices.findUserByEmailEquals(email);
        if(user==null){
            System.out.println("Incorrect username / password");
        }else{
            loggedUser=user;
            System.out.println("Successfully logged in Ivan");
        }
    }
    public void logoutUser(){
        if(loggedUser==null){
            System.out.println("Cannot log out. No user was logged in.");
        }else{
            System.out.println("User "+loggedUser.getFullName()+" successfully logged out");
            loggedUser=null;
        }
    }

    public void addGame(String registerGame){
        String[] splitted=registerGame.split("\\|");
        Game game=new Game();
        game.setTitle(splitted[1]);
        game.setPrice(new BigDecimal(splitted[2]));
        game.setSize(Double.parseDouble(splitted[3]));
        game.setYoutubeUrl(splitted[4]);
        game.setThumbnailUrl(splitted[5]);
        game.setDescription(splitted[6]);
        game.setRealeseDate(new Date(1,1,1));
        this.gameServices.saveGame(game);
    }

    public void viewGame(String viewGameLine){
        String[] splitted=viewGameLine.split("\\|");
        if(splitted[0].equals("AllGame")){
          List<Game> games=this.gameServices.getAll();
            for (Game game : games) {
                System.out.println(game.getTitle()+" "+game.getPrice());
            }
        }else if(splitted[0].equals("DetailGame")){
            Game game=this.gameServices.getGameByTitle(splitted[1]);
            System.out.println(game.getTitle()+" "+game.getPrice());

        }else if(splitted[0].equals("OwnedGame")){
            loggedUser.getGames().stream().forEach(x->{
                System.out.println(x.getTitle());
            });
        }
    }
}
