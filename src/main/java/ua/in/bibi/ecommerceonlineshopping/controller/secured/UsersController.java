package ua.in.bibi.ecommerceonlineshopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UsersRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UsersResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.UsersService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;


    //    create
//    PostMapping("/user")
    @PostMapping
    public UsersResponse create(@RequestBody @Valid UsersRequest usersRequest) throws WrongInputException {
        if (usersRequest.getGroupId() > 0) {
            return usersService.create(usersRequest);
        } else {
            throw new IllegalArgumentException();
        }
    }

    //    read
//    @GetMapping
    @GetMapping("/all")
    public List<UsersResponse> findAll() {
//        System.out.println("GET ALL BRANDS");
        return usersService.findAll();
    }

    @GetMapping
    public DataResponse<UsersResponse> getUsersSortPaginationFindValue(
            @RequestParam(required = false) String value,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {
        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return usersService.findAll(value, page, size, sortFieldName, direction);
            } else {
                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
            }
        } else {
            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
        }

    }

    @GetMapping("/{id}")
    public UsersResponse getBrandById(@PathVariable Long id) {
        if (id > 0) {
//            System.out.println("Get user by id : " + id);
            return usersService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    update
//    @PutMapping("/user")
    @PutMapping
    public UsersResponse update(@RequestBody @Valid UsersRequest usersRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return usersService.update(usersRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    delete
//    @DeleteMapping("/user")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            usersService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }


//    @PostMapping("/userpage")
//    public DataResponse<BrandResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return userService.findAll(paginationRequest);
//    }
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
//    public DataResponse<ProductResponse> findAllByBrandId(@RequestParam Long userId, @RequestBody PaginationRequest paginationRequest) throws WrongInputException {
//        return productService.findAllByBrandId(userId, paginationRequest);
//    }


