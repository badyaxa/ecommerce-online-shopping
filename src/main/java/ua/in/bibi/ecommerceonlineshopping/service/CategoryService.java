package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoryRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoryResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.CategoriesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;

//    create
    public CategoryResponse create(CategoryRequest request) {
        return new CategoryResponse(categoryRequestToCategory(request, null));
    }

    private Categories categoryRequestToCategory(CategoryRequest request, Categories category) {
        if (category == null) {
            category = new Categories();
        }
        category.setName(request.getName());
        return categoriesRepository.save(category);
    }


//    read
    public List<CategoryResponse> findAll() {
        return categoriesRepository
                .findAll()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }


//    update
    public CategoryResponse update(CategoryRequest request, Long id) throws WrongInputException {
        return new CategoryResponse(categoryRequestToCategory(request, findOne(id)));
    }


    public Categories findOne(Long id) throws WrongInputException {
        return categoriesRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Category with id " + id + " not exists"));
    }


//    delete
    public void delete(Long id) throws WrongInputException {
        categoriesRepository.delete(findOne(id));
    }





//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }
}
