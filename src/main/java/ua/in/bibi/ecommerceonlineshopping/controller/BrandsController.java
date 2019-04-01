package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.PaginationRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.BrandsService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;


    //    create
//    PostMapping("/brand")
    @PostMapping
    public BrandsResponse create(@RequestBody @Valid BrandsRequest brandsRequest) {
        return brandsService.create(brandsRequest);
    }

//    @PostMapping("/page")
//    public DataResponse<BrandsResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return brandsService.findAll(paginationRequest);
//    }

    //    read
//    @GetMapping
//    @GetMapping("/all")
//    public List<BrandsResponse> findAll() {
//        System.out.println("GET ALL BRANDS");
//        return brandsService.findAll();
//    }

    @GetMapping("/list")
    public DataResponse<BrandsResponse> getBrandsSortPaginationFindValue(
            @RequestParam(required = false) String value,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {
        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return brandsService.findAll(value, page, size, sortFieldName, direction);
            } else {
                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
            }
        } else {
            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
        }

    }

    @GetMapping("/{id}")
    public BrandsResponse getBrandById(@PathVariable Long id) {
        if (id > 0) {
//            System.out.println("Get brand by id : " + id);
            return brandsService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    update
//    @PutMapping("/brand")
    @PutMapping
    public BrandsResponse update(@RequestBody @Valid BrandsRequest brandsRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return brandsService.update(brandsRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    delete
//    @DeleteMapping("/brand")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            brandsService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

}
