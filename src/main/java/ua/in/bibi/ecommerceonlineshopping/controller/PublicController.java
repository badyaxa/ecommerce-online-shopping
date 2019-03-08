package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsRepository;
import ua.in.bibi.ecommerceonlineshopping.repository.UsersRepository;

@Controller
@RestController
public class PublicController {
//    @Autowired
//    private UsersRepository usersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @GetMapping("/")
    public String helloMsg() {
        return "It is ecommerce online shop";
    }

//    @GetMapping("/products")
//    public Iterable<Products> getAllP() {
//        return productsRepository.findAll();
//    }
//    @GetMapping("/brands")
//    public Iterable<Brands> getAllB() {
//        return brandsRepository.findAll();
//    }


}






//    @RequestMapping("/")
//    public String home() {
//        return "index.html";
//    }





//@RestController
//public class PublicController {
//
//    @Autowired
//    private CountryRepository countryRepository;
//
//    @Autowired
//    private CarRepository carRepository;
//
//    @GetMapping("/")
//    public String helloMsg() {
//        return "Hello";
//    }
//
//    @GetMapping("/country")
//    public Iterable<Country> getAll() {
//        return countryRepository.findAll();
//    }
//
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
//}
