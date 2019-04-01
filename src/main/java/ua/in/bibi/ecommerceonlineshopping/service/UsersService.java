package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.UsersRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.UsersResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.UsersRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.UsersSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {


    @Autowired
    private GroupsService groupsService;

    @Autowired
    private UsersRepository usersRepository;


    //    create
    public UsersResponse create(UsersRequest request) throws WrongInputException {
        return new UsersResponse(userRequestToUser(request, null));
    }


    //    read
    public List<UsersResponse> findAll() {
        return usersRepository
                .findAll()
                .stream()
                .map(UsersResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<UsersResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Users> usersPage;
        if (value != null && !value.equals("")) {
            UsersSpecification specification = new UsersSpecification(value);
            usersPage = usersRepository.findAll(specification, pageRequest);
        } else {
            usersPage = usersRepository.findAll(pageRequest);
        }
        return new DataResponse<UsersResponse>(usersPage.stream().map(UsersResponse::new).collect(Collectors.toList()), usersPage);
    }


    //    update
    public UsersResponse update(UsersRequest request, Long id) throws WrongInputException {
        return new UsersResponse(userRequestToUser(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        usersRepository.delete(findOne(id));
//        usersRepository.deleteById(id);
    }


    public Users findOne(Long id) throws WrongInputException {
        return usersRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("User with id " + id + " not exists"));
    }

    @Transactional
    public UsersResponse findOneById(Long id) {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()) {
            return new UsersResponse(usersOptional.get());
        } else {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
    }


    private Users userRequestToUser(UsersRequest request, Users user) throws WrongInputException {
        if (user == null) {
            user = new Users();
        }
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setGroup(groupsService.findOne(request.getGroupId()));

        return usersRepository.save(user);
    }

//    @GetMapping("/users")
//    public List<UserResponse> findAllUsers() {
//        return userService.findAll();
//    }
//    @GetMapping("/users")
//    public Iterable<Users> getAllB() {
//        return usersRepository.findAll();
//    }

//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
