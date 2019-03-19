package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.PaginationRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.BrandService;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

//    create
    @PostMapping("/brand")
    public BrandResponse create(@RequestBody BrandRequest brandRequest) {
        return brandService.create(brandRequest);
    }

//    read  //in PublicController
//    @GetMapping
    @GetMapping("/brands")
    public List<BrandResponse> findAll() {
        return brandService.findAll();
    }

//    update
    @PutMapping("/brand")
    public BrandResponse update(@RequestBody BrandRequest brandRequest, @RequestParam Long id) throws WrongInputException {
        return brandService.update(brandRequest, id);
    }

//    delete
    @DeleteMapping("/brand")
    public void delete(@RequestParam Long id) throws WrongInputException {
        brandService.delete(id);
    }


//    @PostMapping("/brandpage")
//    public DataResponse<BrandResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return brandService.findAll(paginationRequest);
//    }
}
