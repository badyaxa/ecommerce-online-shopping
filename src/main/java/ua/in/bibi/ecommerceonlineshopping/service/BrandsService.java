package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.BrandsSpecification;

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


//    read
//    public List<BrandsResponse> findAll() {
//        return brandsRepository
//                .findAll()
//                .stream()
//                .map(BrandsResponse::new)
//                .collect(Collectors.toList());
//    }

    public DataResponse<BrandsResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Brands> brandsPage;
        if (value != null && !value.equals("")) {
            BrandsSpecification specification = new BrandsSpecification(value);
            brandsPage = brandsRepository.findAll(specification, pageRequest);
        } else {
            brandsPage = brandsRepository.findAll(pageRequest);
        }
        return new DataResponse<BrandsResponse>(brandsPage.stream().map(BrandsResponse::new).collect(Collectors.toList()), brandsPage);
    }


    //    update
    public BrandsResponse update(BrandsRequest request, Long id) throws WrongInputException {
        return new BrandsResponse(brandRequestToBrand(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        brandsRepository.delete(findOne(id));
    }





    public Brands findOne(Long id) throws WrongInputException {
        return brandsRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Brand with id " + id + " not exists"));
    }

    @Transactional
    private Brands findById(Long id) throws WrongInputException {
        Optional<Brands> optionalBrand = brandsRepository.findById(id);
        if (optionalBrand.isPresent()) {
            return optionalBrand.get();
        }
        throw new WrongInputException("Brand with id : " + id + " not found");
    }


    private Brands brandRequestToBrand(BrandsRequest request, Brands brand) {
        if (brand == null) {
            brand = new Brands();
        }
        brand.setName(request.getName());
        return brandsRepository.save(brand);
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
