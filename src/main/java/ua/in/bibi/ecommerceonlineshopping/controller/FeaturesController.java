package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.FeaturesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.FeaturesResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.FeaturesService;

import javax.validation.Valid;
import javax.xml.ws.Service;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/feature")
public class FeaturesController {

    @Autowired
    private FeaturesService featuresService;


    //    create
//    PostMapping("/feature")
    @PostMapping
    public FeaturesResponse create(@RequestBody @Valid FeaturesRequest featuresRequest) {
        return featuresService.create(featuresRequest);
    }

    //    read
//    @GetMapping
    @GetMapping("/all")
    public List<FeaturesResponse> findAll() {
//        System.out.println("GET ALL BRANDS");
        return featuresService.findAll();
    }

    @GetMapping
    public DataResponse<FeaturesResponse> getFeaturesSortPaginationFindValue(
            @RequestParam(required = false) String value,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {
        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return featuresService.findAll(value, page, size, sortFieldName, direction);
            } else {
                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
            }
        } else {
            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
        }

    }

    @GetMapping("/{id}")
    public FeaturesResponse getBrandById(@PathVariable Long id) {
        if (id > 0) {
//            System.out.println("Get feature by id : " + id);
            return featuresService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    update
//    @PutMapping("/feature")
    @PutMapping
    public FeaturesResponse update(@RequestBody @Valid FeaturesRequest featuresRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return featuresService.update(featuresRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    delete
//    @DeleteMapping("/feature")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            featuresService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }


//    @PostMapping("/featurepage")
//    public DataResponse<BrandResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return featureService.findAll(paginationRequest);
//    }
}
