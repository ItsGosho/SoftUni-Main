package main.controllers;

import main.entities.Tube;
import main.entities.User;
import main.repositories.UserRepository;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summermvc.api.Controller;
import org.softuni.summermvc.api.GetMapping;
import org.softuni.summermvc.api.Model;
import main.repositories.TubeRepository;

import javax.persistence.PersistenceException;
import java.util.List;

@Controller
public class HomeController extends BaseController {
    private TubeRepository tubeRepository;
    private UserRepository userRepository;

    public HomeController() {
        this.tubeRepository = new TubeRepository();
        this.userRepository=new UserRepository();
    }

    @GetMapping(route = "/")
    public String index(HttpSoletRequest request, Model model) {
        System.out.println("INDEX!");
            return super.view(request, model, "index");
    }

    @GetMapping(route = "/home")
    public String home(HttpSoletRequest request, Model model) {
        //TODO: Implement me...
        if(request.getSession()!=null && request.getSession().isValid()){
            String userId= (String) request.getSession().getAttributes().get("user-id");
            User user = this.userRepository.findById(userId);
            model.addAttribute("username",user.getUsername());
            List<Tube> tubes=this.tubeRepository.findAllTubes();
            StringBuilder result=new StringBuilder();
            for (Tube tube : tubes) {
                result.append(tube.extractTubeThumbnailView());
            }
            model.addAttribute("allTubes",result.toString());
            return super.view(request,model,"home");
        }else{
            return super.redirect(request,model,"");
        }
    }
}
