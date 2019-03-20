package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;
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
//    @GetMapping
//    public List<BrandsResponse> findAll() {
//        System.out.println("GET ALL BRANDS");
//        return brandsService.findAll();
//    }

    @GetMapping
    public DataResponse<BrandsResponse> getPersons(@RequestParam(required = false) String value,
                                                   @RequestParam Integer page,
                                                   @RequestParam Integer size,
                                                   @RequestParam String sortFieldName,
                                                   @RequestParam Sort.Direction direction) {
        System.out.println("GET ALL PERSONS");
        return brandsService.findAll(value, page, size, sortFieldName, direction);
    }

//    @GetMapping("/{id}")
//    public BrandsResponse getBrandById(@PathVariable Long id) {
//        System.out.println("Get brand by id : " + id);
//        return brandsService.findOne(id);
//    }

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
