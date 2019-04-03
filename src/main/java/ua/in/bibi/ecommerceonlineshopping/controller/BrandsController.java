package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.PaginationRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.BrandsService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;


    //////////////////create//////////////////
    @PostMapping
    public BrandsResponse create(@RequestBody @Valid BrandsRequest brandsRequest) {
        return brandsService.create(brandsRequest);
    }


    //////////////////read//////////////////
    @GetMapping("/{id}")
    public BrandsResponse getById(@PathVariable Long id) {
        if (id > 0) {
            return brandsService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    @PostMapping("/page")
    public DataResponse<BrandsResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return brandsService.findAll(paginationRequest);
    }


    //////////////////update//////////////////
    @PutMapping
    public BrandsResponse update(@RequestBody @Valid BrandsRequest brandsRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return brandsService.update(brandsRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }


    //////////////////delete//////////////////
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            brandsService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

}
