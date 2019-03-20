package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoriesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoriesResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.CategoriesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    //    create
    public CategoriesResponse create(CategoriesRequest request) {
        return new CategoriesResponse(categoryRequestToCategories(request, null));
    }


    //    read
    public List<CategoriesResponse> findAll() {
        return categoriesRepository
                .findAll()
                .stream()
                .map(CategoriesResponse::new)
                .collect(Collectors.toList());
    }


    //    update
    public CategoriesResponse update(CategoriesRequest request, Long id) throws WrongInputException {
        return new CategoriesResponse(categoryRequestToCategories(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        categoriesRepository.delete(findOne(id));
    }


    public Categories findOne(Long id) throws WrongInputException {
        return categoriesRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Categories with id " + id + " not exists"));
    }


    private Categories categoryRequestToCategories(CategoriesRequest request, Categories category) {
        if (category == null) {
            category = new Categories();
        }
        category.setName(request.getName());
        return categoriesRepository.save(category);
    }


//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }
}
