package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoriesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoriesResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.CategoriesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    //    create
//    @PostMapping("/categories")
    @PostMapping
    public CategoriesResponse create(@RequestBody CategoriesRequest categoriesRequest) {
        return categoriesService.create(categoriesRequest);
    }

    //    read  //in PublicController
//    @GetMapping("/categories")
    @GetMapping
    public List<CategoriesResponse> findAll() {
        return categoriesService.findAll();
    }

    //    update
//    @PutMapping("/categories")
    @PutMapping
    public CategoriesResponse update(@RequestBody CategoriesRequest categoriesRequest, @RequestParam Long id) throws WrongInputException {
        return categoriesService.update(categoriesRequest, id);
    }

    //    delete
//    @DeleteMapping("/categories")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        categoriesService.delete(id);
    }

//    @PostMapping("/categoriespage")
//    public DataResponse<CategoriesResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return categoriesService.findAll(paginationRequest);
//    }
}
