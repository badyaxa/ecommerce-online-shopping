package ua.in.bibi.ecommerceonlineshopping.controller.secured;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/orders")
    public String orders() {
        return "admin";
    }


//    @RequestMapping("/users")
//    public String orders() {
//        return "user";
//    }


}
