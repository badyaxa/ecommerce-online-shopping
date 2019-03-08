package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.BrandRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.BrandResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.BrandsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandsRepository brandsRepository;


//    create
    public BrandResponse create(BrandRequest request) {
        return new BrandResponse(brandRequestToBrand(request, null));
    }

    private Brands brandRequestToBrand(BrandRequest request, Brands brand) {
        if (brand == null) {
            brand = new Brands();
        }
        brand.setName(request.getName());
        return brandsRepository.save(brand);
    }


//    read
    public List<BrandResponse> findAll() {
        return brandsRepository
                .findAll()
                .stream()
                .map(BrandResponse::new)
                .collect(Collectors.toList());
    }


//    update
    public BrandResponse update(BrandRequest request, Long id) throws WrongInputException {
        return new BrandResponse(brandRequestToBrand(request, findOne(id)));
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





//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
