package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.ProductsService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductsController {

//    private String htmlPagePath = "admin/";

    @Autowired
    private ProductsService productsService;

    //    create
//    @GetMapping("/add")
//    public String addProduct(Products product) {
////        Products product = new Products();
////        product.addAttribute("book", book);
//        return htmlPagePath + "addBook";
//    }

    //    @PostMapping("/product")
//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ProductsResponse create(@RequestBody @Valid ProductsRequest productsRequest) throws WrongInputException {
        if (productsRequest.getBrandId() > 0 && productsRequest.getCategoryId() > 0) {
            return productsService.create(productsRequest);
        } else {
            throw new IllegalArgumentException("IDs must not be less than ONE!");
        }
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
//            @RequestParam(required = false, value = "category") String category),
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {

        if (page == null || size == null) {
            throw new IllegalArgumentException("Page and size parameters are required");
        }


        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return productsService.findAll(value, /*category,*/ page, size, sortFieldName, direction);
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

    @RequestMapping("/product_details")
    public String productDetails() {
        return "product_details";
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


//    @RequestMapping(value="/user/{userId}/invoices", method = RequestMethod.GET)
//    public List<Invoice> listUsersInvoices(
//            @PathVariable("userId") int user,
//            @RequestParam(value = "date", required = false) Date dateOrNull) {
//  ...
//    }


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
