package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RestController
public class HomeController {

//    @GetMapping("/")
//    public String helloMsg() {
//        return "It is ecommerce online shop";
//    }

    //    @RequestMapping("/")
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/contact")
    public String contactUs() {
        return "contact";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/forgetpass")
    public String forgetPass() {
        return "forgetpass";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/newsletter")
    public String newsletter() {
        return "newsletter";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}