package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.in.bibi.ecommerceonlineshopping.service.BrandsService;
import ua.in.bibi.ecommerceonlineshopping.service.CategoriesService;
import ua.in.bibi.ecommerceonlineshopping.service.ProductsService;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminHomeController {

    private String htmlPagePath = "admin/";

    @Autowired
    private ProductsService productsService;

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private CategoriesService categoriesService;


    @GetMapping
    public String showAdminHome() {
        return htmlPagePath + "home";
    }

//    @GetMapping("/products")
//    public String showProductsPage(Model model) {
//        model.addAttribute("productList", productService.list());
//        return htmlPagePath + "products";
//    }

    @GetMapping("/orders")
    public String showCustomersOrdersPage() {
        return htmlPagePath + "orders";
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:home";
    }

    @RequestMapping("/home")
    public String home(Principal principal) {
        return htmlPagePath + "home";
    }

    @RequestMapping("/login")
    public String login() {
        return htmlPagePath + "login";
    }


    @RequestMapping("/users")
    public String users() {
        return htmlPagePath + "users";
    }


}

