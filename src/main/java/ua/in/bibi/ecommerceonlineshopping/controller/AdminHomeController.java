package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.in.bibi.ecommerceonlineshopping.service.BrandsService;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminHomeController {

    private String htmlPagePath = "admin/";

//    @Autowired
//    private ProductsService productsService;

    @Autowired
    private BrandsService brandsService;

//    @Autowired
//    private CategoriesService categoriesService;

    @GetMapping
//    @RequestMapping("/")
    public String index() {
        return "redirect:home";
    }

    //    @RequestMapping("/home")
    @GetMapping("/home")
    public String home() {
        return htmlPagePath + "home";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return htmlPagePath + "login";
//    }

    @GetMapping("/brands")
    public String showBrandsPage() {
        return htmlPagePath + "brands";
    }

//    @GetMapping("/products")
//    public String showProductsPage(Model model) {
//        model.addAttribute("productList", productService.list());
//        return htmlPagePath + "products";
//    }

//    @GetMapping("/orders")
//    public String showCustomersOrdersPage() {
//        return htmlPagePath + "orders";
//    }


//    @RequestMapping("/users")
//    public String users() {
//        return htmlPagePath + "users";
//    }


    /**
     * Show product inventory list.
     *
     * @param model
     * @return
     */
//    @GetMapping("/product-inventory")
//    public String showProductInventoryPage(Model model) {
//        model.addAttribute("productList", productService.list());
//        return "admin/product-inventory";
//    }

    /**
     * Show product inventory list.
     *
     * @param model
     * @return
     */
//    @GetMapping("/order-management")
//    public String showCustomerOrderPage(Model model) {
//        model.addAttribute("customerOrderList", customerOrderService.list());
//        return "admin/order-management";
//    }
//
//    @GetMapping("/customer-management")
//    public String showCustomerManagementPage(Model model) {
//        // TODO
//        return "admin/customer-management";
//    }

}
