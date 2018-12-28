package itsgosho.controllers;

import itsgosho.domain.entities.User;
import itsgosho.domain.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping(value = "/exists", produces = "application/json")
    @ResponseBody
    public String usernameExistsGET(@RequestParam(required = false) String username, @RequestParam(required = false) String email) {
        return this.userServices.determinateIfExistsForJSON(username, email);
    }

    @GetMapping(value = "/isvalid", produces = "application/json")
    @ResponseBody
    public String isValidGET(@RequestParam String username, @RequestParam String password) {
        return this.userServices.determinateIfLoginValidForJSON(username, password);
    }

    @GetMapping("/show")
    public ModelAndView showGET(ModelAndView modelAndView,Principal principal) {
        modelAndView.addObject("users",this.userServices.findAll());
        return super.page("main-page", "users/show-users-table", "All users",modelAndView);
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deletePOST(@PathVariable String id, Principal principal) {
        if(principal!=null && this.userServices.findById(id)!=null){
            this.userServices.deleteUser(principal,id);
        }
        return super.redirect("/users/show");
    }

    @PostMapping("/promote/{id}")
    public ModelAndView promotePOST(@PathVariable String id, Principal principal) {
        if(principal!=null && this.userServices.findById(id)!=null){
            this.userServices.promoteUser(principal,id);
        }
        return super.redirect("/users/show");
    }

    @PostMapping("/demote/{id}")
    public ModelAndView demotePOST(@PathVariable String id, Principal principal) {
        if(principal!=null && this.userServices.findById(id)!=null){
            this.userServices.demoteUser(principal,id);
        }
        return super.redirect("/users/show");
    }
}
