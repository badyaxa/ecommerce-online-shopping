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
import ua.in.bibi.ecommerceonlineshopping.entity.ProductsCategories;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsCategoriesRepository;

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
    public ProductsCategoriesResponse create(ProductsCategoriesRequest request) {
        if (request.getCategoryId() > 0 && request.getProductId() > 0) {

//            ProductsCategoriesRepository productsCategoriesRepository = new ProductsCategoriesRepository();
            return
                    null
//                    new ProductsCategoriesResponse(
//                            brandRequestToBrand(request, null)
//                    )
                    ;
        } else {
            throw new IllegalArgumentException("Bad ProductsCategories request");
        }
//        productsCategoriesRepository.exists(Example<request>, request);

//        private Brands brandRequestToBrand(BrandsRequest request, Brands brand) {
//            if (brand == null) {
//                brand = new Brands();
//            }
//            brand.setName(request.getName());
//            return brandsRepository.save(brand);
//        }
    }


    //    read
//    public List<ProductsCategoriesResponse> findAll() {
//        return brandsRepository
//                .findAll()
//                .stream()
//                .map(ProductsCategoriesResponse::new)
//                .collect(Collectors.toList());
//    }


}
