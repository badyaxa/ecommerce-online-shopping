package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.ProductService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    create
//    @PostMapping("/product")
//    @ResponseStatus(HttpStatus.CREATED)
@PostMapping
public ProductResponse create(@RequestBody ProductRequest productRequest) throws WrongInputException {
        return productService.create(productRequest);
    }

//    read  //in PublicController
//    @GetMapping("/products")
@GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

//    update
//    @PutMapping("/product")
@PutMapping
    public ProductResponse update(@RequestParam Long id, @RequestBody ProductRequest productRequest) throws WrongInputException {
        return productService.update(id, productRequest);
    }

//    delete
//    @DeleteMapping("/product")
@DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        productService.delete(id);
    }

//    @GetMapping("/title/{bookTitle}")
//    public List findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
//    }

//    @GetMapping("/{id}")
//    public Book findOne(@PathVariable Long id) {
//        return bookRepository.findById(id)
//                .orElseThrow(BookNotFoundException::new);
//    }


//    @PostMapping("/filter")
//    public DataResponse<ProductResponse> findAllByFilter(@RequestBody ProductFilterRequest productFilterRequest) {
//        return productService.findByFilter(productFilterRequest);
//    }

//    @PostMapping("/page/byBrandId")
//    public DataResponse<ProductResponse> findAllByBrandId(@RequestParam Long brandId, @RequestBody PaginationRequest paginationRequest) throws WrongInputException {
//        return productService.findAllByBrandId(brandId, paginationRequest);
//    }
}
