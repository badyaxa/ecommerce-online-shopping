package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private BrandsService brandsService;


    //    create
    public ProductsResponse create(ProductsRequest productRequest) throws WrongInputException {
        Products product = new Products();
        product.setName(productRequest.getName());
        product.setBrand(brandsService.findOne(productRequest.getIdBrand()));
//        product.setCategory(categoriesService.getPetType());
        return new ProductsResponse(productsRepository.save(product));

//        return new ProductsResponse(productRequestToProducts(null, productRequest));
    }


    //    read
    public List<ProductsResponse> findAll() {
        return productsRepository
                .findAll()
                .stream()
                .map(ProductsResponse::new)
                .collect(Collectors.toList());
    }


    //    update
    public ProductsResponse update(Long id, ProductsRequest productsRequest) throws WrongInputException {
        return new ProductsResponse(productRequestToProducts(findOne(id), productsRequest));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        productsRepository.delete(findOne(id));
    }


    public Products findOne(Long id) throws WrongInputException {
        return productsRepository.findById(id).orElseThrow(() -> new WrongInputException("Products with id " + id + " not exists"));
    }


    private Products productRequestToProducts(Products product, ProductsRequest request) throws WrongInputException {
        if (product == null) {
            product = new Products();
        }
        product.setName(request.getName());
        product.setBrand(brandsService.findOne(request.getIdBrand()));
//        product.setVolume(request.getVolume());
//        product.setYear(request.getYear());
        return productsRepository.save(product);
    }


//    @GetMapping("/products")
//    public List<ProductResponse> findAllProducts() {
//        return productService.findAll();
//    }
//    @GetMapping("/products")
//    public Iterable<Products> getAllP() {
//        return productsRepository.findAll();
//    }


//    @GetMapping("/data")
//    public List<String> getOneByName(@RequestParam(required = false) Integer count) {
//        List<String> data = new ArrayList<>();
//        count = count != null ? count : 3;
//        for (int i = 0; i < count; i++) {
//            data.add(String.format("%.2f", Math.random() * 100));
//        }
//        return data;
//    }
//
//    @PostMapping("/data")
//    public List<Car> findByVolume(@RequestBody CarFindByVolumeRequest request) {
//        System.out.println(request.getFrom());
//        System.out.println(request.getTo());
//        return carRepository.findByVolume(request.getFrom(), request.getTo());
//    }


//    public DataResponse<ProductsResponse> findByFilter(ProductsFilterRequest filterRequest) {
//        Page<Products> page = productRepository.findAll(
//                new ProductsSpecification(filterRequest),
//                filterRequest.getPagination().mapToPageRequest());
//
//        return new DataResponse<>(page.get().map(ProductsResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//
//    }

//    public DataResponse<ProductsResponse> findAllByBrandId(Long brandId, PaginationRequest paginationRequest) throws WrongInputException {
//        Brand brand = brandsService.findOne(brandId);
//        Page<Products> byBrand = productRepository.findAllByBrand(brand, paginationRequest.mapToPageRequest());
//        return new DataResponse<>(byBrand.get().map(ProductsResponse::new).collect(Collectors.toList()),
//                byBrand.getTotalPages(), byBrand.getTotalElements());
//    }
}

