package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoryRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.PaginationRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoryResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.CategoryService;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //    create
    @PostMapping("/category")
    public CategoryResponse create(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }

    //    read  //in PublicController
//    @GetMapping
    @GetMapping("/categories")
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    //    update
    @PutMapping("/category")
    public CategoryResponse update(@RequestBody CategoryRequest categoryRequest, @RequestParam Long id) throws WrongInputException {
        return categoryService.update(categoryRequest, id);
    }

    //    delete
    @DeleteMapping("/category")
    public void delete(@RequestParam Long id) throws WrongInputException {
        categoryService.delete(id);
    }

//    @PostMapping("/categoriespage")
//    public DataResponse<CategoryResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return categoryService.findAll(paginationRequest);
//    }
}
