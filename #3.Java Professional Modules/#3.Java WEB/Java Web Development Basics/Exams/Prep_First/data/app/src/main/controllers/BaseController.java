package main.controllers;

import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.summermvc.api.Controller;
import org.softuni.summermvc.api.Model;

@Controller
public class BaseController {

    private boolean isLoggedIn(HttpSoletRequest request) {
        return request.getSession().getAttributes().containsKey("user-id");
    }

    public String view(HttpSoletRequest request, Model model, String view) {
        return "template:" + view;
    }

    public String redirect(HttpSoletRequest request, Model model, String view) {
        return "redirect:/" + view;
    }
}
