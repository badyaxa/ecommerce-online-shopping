package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.ProductsService;

import javax.validation.Valid;
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
    public ProductsResponse create(@RequestBody @Valid ProductsRequest productsRequest) throws WrongInputException {
        return productsService.create(productsRequest);
    }

    //    read
//    @GetMapping("/products")
    @GetMapping("/all")
    public List<ProductsResponse> findAll() {
        return productsService.findAll();
    }

    @GetMapping
    public DataResponse<ProductsResponse> getProductsSortPaginationFindValue(
            @RequestParam(required = false) String value,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {
        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return productsService.findAll(value, page, size, sortFieldName, direction);
            } else {
                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
            }
        } else {
            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
        }

    }

    @GetMapping("/{id}")
    public ProductsResponse getProductsById(@PathVariable Long id) {
        if (id > 0) {
            return productsService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    update
//    @PutMapping("/product")
    @PutMapping
    public ProductsResponse update(@RequestParam Long id, @RequestBody ProductsRequest productsRequest) throws WrongInputException {
        if (id > 0) {
            return productsService.update(id, productsRequest);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    delete
//    @DeleteMapping("/product")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            productsService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
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
