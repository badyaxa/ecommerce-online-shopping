package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UsersRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UsersResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

//    @Autowired
//    private BrandService brandService;

    //    create
    public UsersResponse create(UsersRequest usersRequest) throws WrongInputException {
        return new UsersResponse(userRequestToUser(null, usersRequest));
    }


    //    read
    public List<UsersResponse> findAll() {
        return usersRepository
                .findAll()
                .stream()
                .map(UsersResponse::new)
                .collect(Collectors.toList());
    }


    //    update
    public UsersResponse update(Long id, UsersRequest usersRequest) throws WrongInputException {
        return new UsersResponse(userRequestToUser(findOne(id), usersRequest));
    }


    public Users findOne(Long id) throws WrongInputException {
        return usersRepository.findById(id).orElseThrow(() -> new WrongInputException("User with id " + id + " not exists"));
    }

    private Users userRequestToUser(Users user, UsersRequest request) throws WrongInputException {
        if (user == null) {
            user = new Users();
        }
        user.setName(request.getName());
//        user.setBrand(brandService.findOne(request.getBrandId()));
        user.setEmail(request.getEmail());
//        user.setYear(request.getYear());
        return usersRepository.save(user);
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        usersRepository.delete(findOne(id));
    }


//    public DataResponse<ProductResponse> findByFilter(ProductFilterRequest filterRequest) {
//        Page<Product> page = productRepository.findAll(
//                new ProductSpecification(filterRequest),
//                filterRequest.getPagination().mapToPageRequest());
//
//        return new DataResponse<>(page.get().map(ProductResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//
//    }
//
//    public DataResponse<ProductResponse> findAllByBrandId(Long brandId, PaginationRequest paginationRequest) throws WrongInputException {
//        Brand brand = brandService.findOne(brandId);
//        Page<Product> byBrand = productRepository.findAllByBrand(brand, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byBrand.get().map(ProductResponse::new).collect(Collectors.toList()),
//                byBrand.getTotalPages(), byBrand.getTotalElements());
//    }
}

