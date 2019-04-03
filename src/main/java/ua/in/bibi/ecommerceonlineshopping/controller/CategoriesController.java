package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoriesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.PaginationRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoriesResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.CategoriesService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    //////////////////create//////////////////
    @PostMapping
    public CategoriesResponse create(@RequestBody @Valid CategoriesRequest categoriesRequest) {
        return categoriesService.create(categoriesRequest);
    }


    //////////////////read//////////////////
    @GetMapping("/{id}")
    public CategoriesResponse getCategoryById(@PathVariable Long id) {
        if (id > 0) {
            return categoriesService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    @PostMapping("/page")
    public DataResponse<CategoriesResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return categoriesService.findAll(paginationRequest);
    }


    @GetMapping("/all")
    public List<CategoriesResponse> findAll() {
        return categoriesService.findAll();
    }


    //////////////////update//////////////////
    @PutMapping
    public CategoriesResponse update(@RequestBody @Valid CategoriesRequest categoriesRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return categoriesService.update(categoriesRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }


    //////////////////delete//////////////////
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            categoriesService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

//    @GetMapping
//    public DataResponse<CategoriesResponse> getCategoriesSortPaginationFindValue(
//            @RequestParam(required = false) String value,
//            @RequestParam Integer page,
//            @RequestParam Integer size,
//            @RequestParam String sortFieldName,
//            @RequestParam Sort.Direction direction) {
//        if (page >= 0) {
//            if (size > 0) {
////                System.out.println("GET ALL BRANDS pageble");
//                return categoriesService.findAll(value, page, size, sortFieldName, direction);
//            } else {
//                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
//            }
//        } else {
//            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
//        }
//
//    }

}
