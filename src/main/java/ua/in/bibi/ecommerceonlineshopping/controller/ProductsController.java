package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.ProductsService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

//    create
//    @PostMapping("/product")
//    @ResponseStatus(HttpStatus.CREATED)
@PostMapping
public ProductsResponse create(@RequestBody ProductsRequest productsRequest) throws WrongInputException {
    return productsService.create(productsRequest);
    }

//    read  //in PublicController
//    @GetMapping("/products")
@GetMapping
public List<ProductsResponse> findAll() {
    return productsService.findAll();
    }

//    update
//    @PutMapping("/product")
@PutMapping
public ProductsResponse update(@RequestParam Long id, @RequestBody ProductsRequest productsRequest) throws WrongInputException {
    return productsService.update(id, productsRequest);
    }

//    delete
//    @DeleteMapping("/product")
@DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
    productsService.delete(id);
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
