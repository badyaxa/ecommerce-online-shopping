package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;


    //    create
    public BrandsResponse create(BrandsRequest request) {
        return new BrandsResponse(brandRequestToBrand(request, null));
    }


    private Brands brandRequestToBrand(BrandsRequest request, Brands brand) {
        if (brand == null) {
            brand = new Brands();
        }
        brand.setName(request.getName());
        return brandsRepository.save(brand);
    }


    //    read
    public List<BrandsResponse> findAll() {
        return brandsRepository
                .findAll()
                .stream()
                .map(BrandsResponse::new)
                .collect(Collectors.toList());
    }


    //    update
    public BrandsResponse update(BrandsRequest request, Long id) throws WrongInputException {
        return new BrandsResponse(brandRequestToBrand(request, findOne(id)));
    }


    public Brands findOne(Long id) throws WrongInputException {
        return brandsRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Brand with id " + id + " not exists"));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        brandsRepository.delete(findOne(id));
    }


    private Brands findById(Long id) throws WrongInputException {
        Optional<Brands> optionalBrand = brandsRepository.findById(id);
        if (optionalBrand.isPresent()) {
            return optionalBrand.get();
        }
        throw new WrongInputException("Brand with id : " + id + " not found");
    }


//    @GetMapping("/brands")
//    public List<BrandResponse> findAllBrands() {
//        return brandService.findAll();
//    }
//    @GetMapping("/brands")
//    public Iterable<Brands> getAllB() {
//        return brandsRepository.findAll();
//    }

//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
