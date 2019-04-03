package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
//@RestController
@RequestMapping
public class HomeController {

//    @GetMapping("/")
//    public String helloMsg() {
//        return "It is ecommerce online shop";
//    }

    @GetMapping
//    @RequestMapping("/")
    public String index() {
        return "redirect:index";
    }

    //    @RequestMapping("/")
    @GetMapping("/index")
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


    @GetMapping("/brands")
    public String showBrandsPage() {
        return "brands";
    }

    @GetMapping("/categories")
    public String showCategoriesPage() {
        return "categories";
    }

    @GetMapping("/products")
    public String showProductsPage() {
        return "products";
    }

}
