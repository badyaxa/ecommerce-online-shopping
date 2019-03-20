package ua.in.bibi.ecommerceonlineshopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UserRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UserResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UserService userService;

    //    create
//    @PostMapping("/user")
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserRequest userRequest) throws WrongInputException {
        return userService.create(userRequest);
    }

    //    read
//    @GetMapping("/users")
    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    //    update
//    @PutMapping("/user")
    @PutMapping
    public UserResponse update(@RequestParam Long id, @RequestBody UserRequest userRequest) throws WrongInputException {
        return userService.update(id, userRequest);
    }

    //    delete
//    @DeleteMapping("/user")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        userService.delete(id);
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

