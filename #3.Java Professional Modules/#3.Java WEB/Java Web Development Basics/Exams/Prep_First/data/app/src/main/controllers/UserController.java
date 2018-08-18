package main.controllers;

import main.entities.Tube;
import main.entities.User;
import main.models.binding.UserLoginBindingModel;
import main.models.binding.UserRegisterBindingModel;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.javache.http.HttpSessionImpl;
import org.softuni.summermvc.api.Controller;
import org.softuni.summermvc.api.GetMapping;
import org.softuni.summermvc.api.Model;
import org.softuni.summermvc.api.PostMapping;
import main.repositories.TubeRepository;
import main.repositories.UserRepository;

import java.util.List;

@Controller
public class UserController extends BaseController {
    private UserRepository userRepository;
    private TubeRepository tubeRepository;

    public UserController() {
        this.userRepository = new UserRepository();
        this.tubeRepository = new TubeRepository();
    }

    @GetMapping(route = "/login")
    public String login(HttpSoletRequest request, Model model) {
        return super.view(request, model, "login");

    }

    @GetMapping(route = "/profile")
    public String profile(HttpSoletRequest request, Model model) {

        if (request.getSession() != null && request.getSession().isValid()) {
            User currentUser = this.userRepository.findById(request.getSession().getAttributes().get("user-id").toString());

            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("email", currentUser.getEmail());

            StringBuilder result = new StringBuilder();
            List<Tube> uploadedTubes = this.tubeRepository.findUserUploadedTubes(currentUser.getId());

            for (int i = 0; i < uploadedTubes.size(); i++) {
                Tube currentTube = uploadedTubes.get(i);
                result.append(String.format(currentTube.extractTubeTableView(), i + 1));
            }

            if (!uploadedTubes.isEmpty()) result.append("</div>");

            model.addAttribute("myTubes", result.toString());

            return super.view(request, model, "profile");
        } else {
            return super.redirect(request, model, "");
        }
    }

    @PostMapping(route = "/login")
    public String loginConfirm(HttpSoletRequest request, UserLoginBindingModel userLoginBindingModel, Model model) {
        if (userLoginBindingModel == null || userLoginBindingModel.getUsername() == null || userLoginBindingModel.getPassword() == null) {
            return super.view(request, model, "login");
        }

        User registeredUser = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (registeredUser == null ||
                !registeredUser.getPassword().equals(userLoginBindingModel.getPassword())) {
            return super.view(request, model, "login");
        }

        request.setSession(new HttpSessionImpl());
        model.addAttribute("username", registeredUser.getUsername());
        request.getSession().addAttribute("user-id", registeredUser.getId());
        request.getSession().addAttribute("username", registeredUser.getUsername());

        // return "redirect:/home";
        return super.redirect(request, model, "home");
    }

    @GetMapping(route = "/register")
    public String register(HttpSoletRequest request, Model model) {
        return super.view(request, model, "register");
    }

    @PostMapping(route = "/register")
    public String registerConfirm(UserRegisterBindingModel userRegisterBindingModel, HttpSoletRequest request, Model model) {

        if (request.getSession() == null && !request.getSession().isValid()) {
            if (userRegisterBindingModel == null || userRegisterBindingModel.getUsername() == null
                    || userRegisterBindingModel.getPassword() == null
                    || userRegisterBindingModel.getConfirmPassword() == null
                    && userRegisterBindingModel.getEmail() == null) {
                return super.view(request, model, "register");
            }

            String email = userRegisterBindingModel.getEmail();

            if (!userRegisterBindingModel.getPassword()
                    .equals(userRegisterBindingModel.getConfirmPassword())) {
                return super.view(request, model, "register");
            }

            if (this.userRepository
                    .findByUsername(userRegisterBindingModel.getUsername())
                    != null) {
                return super.view(request, model, "register");
            }

            User user = new User();

            user.setUsername(userRegisterBindingModel.getUsername());
            user.setPassword(userRegisterBindingModel.getPassword());
            user.setEmail(userRegisterBindingModel.getEmail());

            this.userRepository.createUser(user);

            return super.redirect(request, model, "login");
        } else {
            return super.redirect(request, model, "home");
        }
    }

    @GetMapping(route = "/logout")
    public String logout(HttpSoletRequest request, Model model) {
        if (request.getSession() != null && request.getSession().isValid()) {
            request.getSession().invalidate();
            return super.redirect(request, model, "");
        } else {
            return super.redirect(request, model, "");
        }
    }
}
