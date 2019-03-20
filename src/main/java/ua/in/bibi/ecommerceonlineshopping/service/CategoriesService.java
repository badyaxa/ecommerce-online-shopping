package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.CategoriesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.CategoriesResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.CategoriesRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.CategoriesSpecification;

import java.util.List;
import java.util.Optional;
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

    public DataResponse<CategoriesResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Categories> categoriesPage;
        if (value != null && !value.equals("")) {
            CategoriesSpecification specification = new CategoriesSpecification(value);
            categoriesPage = categoriesRepository.findAll(specification, pageRequest);
        } else {
            categoriesPage = categoriesRepository.findAll(pageRequest);
        }
        return new DataResponse<CategoriesResponse>(categoriesPage.stream().map(CategoriesResponse::new).collect(Collectors.toList()), categoriesPage);
    }


    //    update
    public CategoriesResponse update(CategoriesRequest request, Long id) throws WrongInputException {
        return new CategoriesResponse(categoryRequestToCategories(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        categoriesRepository.delete(findOne(id));
//        categoriesRepository.deleteById(id);
    }


    public Categories findOne(Long id) throws WrongInputException {
        return categoriesRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Categories with id " + id + " not exists"));
    }

    @Transactional
    public CategoriesResponse findOneById(Long id) {
        Optional<Categories> brandsOptional = categoriesRepository.findById(id);
        if (brandsOptional.isPresent()) {
            return new CategoriesResponse(brandsOptional.get());
        } else {
            throw new IllegalArgumentException("Brand with id " + id + " not found");
        }
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
