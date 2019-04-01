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
    private BrandsRepository usersRepository;


    //    create
    public BrandsResponse create(BrandsRequest request) {
        return new BrandsResponse(userRequestToBrand(request, null));
    }


    //    read
    public List<BrandsResponse> findAll() {
        return usersRepository
                .findAll()
                .stream()
                .map(BrandsResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<BrandsResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Brands> usersPage;
        if (value != null && !value.equals("")) {
            BrandsSpecification specification = new BrandsSpecification(value);
            usersPage = usersRepository.findAll(specification, pageRequest);
        } else {
            usersPage = usersRepository.findAll(pageRequest);
        }
        return new DataResponse<BrandsResponse>(usersPage.stream().map(BrandsResponse::new).collect(Collectors.toList()), usersPage);
    }


    //    update
    public BrandsResponse update(BrandsRequest request, Long id) throws WrongInputException {
        return new BrandsResponse(userRequestToBrand(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        usersRepository.delete(findOne(id));
//        usersRepository.deleteById(id);
    }


    public Brands findOne(Long id) throws WrongInputException {
        return usersRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Brand with id " + id + " not exists"));
    }

    @Transactional
    public BrandsResponse findOneById(Long id) {
        Optional<Brands> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()) {
            return new BrandsResponse(usersOptional.get());
        } else {
            throw new IllegalArgumentException("Brand with id " + id + " not found");
        }
    }


    private Brands userRequestToBrand(BrandsRequest request, Brands user) {
        if (user == null) {
            user = new Brands();
        }
        user.setName(request.getName());
        return usersRepository.save(user);
    }

//    @GetMapping("/users")
//    public List<BrandResponse> findAllBrands() {
//        return userService.findAll();
//    }
//    @GetMapping("/users")
//    public Iterable<Brands> getAllB() {
//        return usersRepository.findAll();
//    }

//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
