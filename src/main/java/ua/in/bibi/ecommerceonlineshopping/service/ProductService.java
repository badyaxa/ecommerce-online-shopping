package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BrandService brandService;

//    create
    public ProductResponse create(ProductRequest productRequest) throws WrongInputException {
        return new ProductResponse(productRequestToProduct(null, productRequest));
    }


//    read
    public List<ProductResponse> findAll() {
        return productsRepository
                .findAll()
                .stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }


//    update
    public ProductResponse update(Long id, ProductRequest productRequest) throws WrongInputException {
        return new ProductResponse(productRequestToProduct(findOne(id), productRequest));
    }

    public Products findOne(Long id) throws WrongInputException {
        return productsRepository.findById(id).orElseThrow(() -> new WrongInputException("Product with id " + id + " not exists"));
    }

    private Products productRequestToProduct(Products product, ProductRequest request) throws WrongInputException {
        if (product == null) {
            product = new Products();
        }
        product.setName(request.getName());
        product.setBrand(brandService.findOne(request.getBrandId()));
//        product.setVolume(request.getVolume());
//        product.setYear(request.getYear());
        return productsRepository.save(product);
    }


//    delete
    public void delete(Long id) throws WrongInputException {
        productsRepository.delete(findOne(id));
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

