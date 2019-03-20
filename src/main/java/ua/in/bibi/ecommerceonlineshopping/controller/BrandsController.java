package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;
import ua.in.bibi.ecommerceonlineshopping.service.BrandsService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @Autowired
    private BrandsRepository brandsRepository;

//    create
//    PostMapping("/brand")
@PostMapping
public BrandsResponse create(@RequestBody BrandsRequest brandsRequest) {
    return brandsService.create(brandsRequest);
    }

    //    read
//    @GetMapping("/brands")
    @GetMapping
    public List<BrandsResponse> findAll() {
        return brandsService.findAll();
    }

//    update
//    @PutMapping("/brand")
@PutMapping
public BrandsResponse update(@RequestBody BrandsRequest brandsRequest, @RequestParam Long id) throws WrongInputException {
    return brandsService.update(brandsRequest, id);
    }

//    delete
//    @DeleteMapping("/brand")
@DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
    brandsService.delete(id);
    }


//    @PostMapping("/brandpage")
//    public DataResponse<BrandResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return brandService.findAll(paginationRequest);
//    }
}
