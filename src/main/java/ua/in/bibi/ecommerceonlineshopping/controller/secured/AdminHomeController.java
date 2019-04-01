package ua.in.bibi.ecommerceonlineshopping.controller.secured;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminHomeController {

    private String path = "admin/";

    @RequestMapping("/")
    public String index() {
        return "redirect:home";
    }

    @RequestMapping("/home")
    public String home(Principal principal) {

        return path + "home";
    }

    @RequestMapping("/login")
    public String login() {
        return path + "login";
    }

    @RequestMapping("/orders")
    public String orders() {
        return "admin";
    }


//    @RequestMapping("/users")
//    public String orders() {
//        return "user";
//    }


}

