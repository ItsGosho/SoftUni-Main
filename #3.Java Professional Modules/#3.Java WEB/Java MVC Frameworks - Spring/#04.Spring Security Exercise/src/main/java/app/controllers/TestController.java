package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("user/test")
    @ResponseBody
    public String test(){
        return "<h1>User Test</h1>";
    }

    @GetMapping("admin/test")
    @ResponseBody
    public String test2(){
        return "<h1>Admin Test</h1>";
    }

    @GetMapping("all/test")
    public String determinateThymeleafSecurityTest(){
        return "test/determinate-role";
    }
}
