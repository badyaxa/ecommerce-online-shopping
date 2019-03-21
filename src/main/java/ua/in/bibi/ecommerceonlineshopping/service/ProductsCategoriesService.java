package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsCategoriesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsCategoriesResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.entity.ProductsCategories;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsCategoriesRepository;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsCategoriesService {

    @Autowired
    private ProductsCategoriesRepository productsCategoriesRepository;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoriesService categoriesService;


    //    create
    public ProductsCategoriesResponse create(ProductsCategoriesRequest productsCategoriesRequest) throws WrongInputException {
        @Positive Long categoryId = productsCategoriesRequest.getCategoryId();
        @Positive Long productId = productsCategoriesRequest.getProductId();
        if (categoryId > 0 && productId > 0) {

            ProductsCategories productsCategories = new ProductsCategories();

//            productsCategories.setCategoryId(productsCategoriesRequest.getCategoryId());
            Categories categoriesServiceOne = categoriesService.findOne(categoryId);
            System.out.println(categoriesServiceOne);
            productsCategories.setCategory(categoriesServiceOne);

//            productsCategories.setProductId(productsCategoriesRequest.getProductId());
            Products productsServiceOne = productsService.findOne(productId);
            System.out.println(productsServiceOne);
            productsCategories.setProduct(productsServiceOne);

            ProductsCategories save = productsCategoriesRepository.save(productsCategories);
            System.out.println(save);
            return new ProductsCategoriesResponse(save);
//            return new ProductsCategoriesResponse(productsCategoriesRequestToproductsCategories(save., null));

        } else {
            throw new IllegalArgumentException("Bad ProductsCategories request");
        }
//
    }


    //    read
//    public List<ProductsCategoriesResponse> findAll() {
//        return brandsRepository
//                .findAll()
//                .stream()
//                .map(ProductsCategoriesResponse::new)
//                .collect(Collectors.toList());
//    }

//    private ProductsCategories productsCategoriesRequestToproductsCategories(ProductsCategoriesRequest request, ProductsCategories productsCategories) {
//        if (productsCategories == null) {
//            productsCategories = new ProductsCategories();
//        }
//        productsCategories.setCategory(request.getCategoryId());
//        return productsCategoriesRepository.save(productsCategories);
//    }
}
