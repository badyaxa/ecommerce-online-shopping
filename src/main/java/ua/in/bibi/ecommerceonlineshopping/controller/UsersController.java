package ua.in.bibi.ecommerceonlineshopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UsersRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UsersResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.UsersService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService usersService;

    //    create
//    @PostMapping("/user")
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public UsersResponse create(@RequestBody UsersRequest usersRequest) throws WrongInputException {
        return usersService.create(usersRequest);
    }

    //    read
//    @GetMapping("/users")
    @GetMapping
    public List<UsersResponse> findAll() {
        return usersService.findAll();
    }

    //    update
//    @PutMapping("/user")
    @PutMapping
    public UsersResponse update(@RequestParam Long id, @RequestBody UsersRequest usersRequest) throws WrongInputException {
        return usersService.update(id, usersRequest);
    }

    //    delete
//    @DeleteMapping("/user")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        usersService.delete(id);
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

