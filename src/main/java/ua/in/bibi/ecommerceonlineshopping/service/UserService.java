package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UserRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UserResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

//    @Autowired
//    private BrandService brandService;

    //    create
    public UserResponse create(UserRequest userRequest) throws WrongInputException {
        return new UserResponse(userRequestToUser(null, userRequest));
    }


    //    read
    public List<UserResponse> findAll() {
        return usersRepository
                .findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }


    //    update
    public UserResponse update(Long id, UserRequest userRequest) throws WrongInputException {
        return new UserResponse(userRequestToUser(findOne(id), userRequest));
    }


    public Users findOne(Long id) throws WrongInputException {
        return usersRepository.findById(id).orElseThrow(() -> new WrongInputException("User with id " + id + " not exists"));
    }

    private Users userRequestToUser(Users user, UserRequest request) throws WrongInputException {
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

