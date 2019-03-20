package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductResponse;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsRepository;
import ua.in.bibi.ecommerceonlineshopping.repository.UsersRepository;
import ua.in.bibi.ecommerceonlineshopping.service.BrandService;
import ua.in.bibi.ecommerceonlineshopping.service.ProductService;

import java.util.List;

@Controller
//@RestController
public class PublicController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

//    @Autowired
//    private BrandsRepository brandsRepository;

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

    @GetMapping("/admin")
     public String admin() {
        return "admin";
    }

//    @GetMapping("/brand")
//     public String crudBrand() {
//        return "brand";
//    }

//    @GetMapping("/category")
//     public String crudCategory() {
//        return "category";
//    }

    @GetMapping("/contactus")
     public String contactus() {
        return "contactus";
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

//    @GetMapping("/product")
//     public String crudProduct() {
//        return "product";
//    }


//    @GetMapping("/brands")
//    public List<BrandResponse> findAllBrands() {
//        return brandService.findAll();
//    }
//    @GetMapping("/brands")
//    public Iterable<Brands> getAllB() {
//        return brandsRepository.findAll();
//    }


//    @GetMapping("/products")
//    public List<ProductResponse> findAllProducts() {
//        return productService.findAll();
//    }
//    @GetMapping("/products")
//    public Iterable<Products> getAllP() {
//        return productsRepository.findAll();
//    }



//    @GetMapping("/data")
//    public List<String> getOneByName(@RequestParam(required = false) Integer count) {
//        List<String> data = new ArrayList<>();
//        count = count != null ? count : 3;
//        for (int i = 0; i < count; i++) {
//            data.add(String.format("%.2f", Math.random() * 100));
//        }
//        return data;
//    }
//
//    @PostMapping("/data")
//    public List<Car> findByVolume(@RequestBody CarFindByVolumeRequest request) {
//        System.out.println(request.getFrom());
//        System.out.println(request.getTo());
//        return carRepository.findByVolume(request.getFrom(), request.getTo());
//    }

}
