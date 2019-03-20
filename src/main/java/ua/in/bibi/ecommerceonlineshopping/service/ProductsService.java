package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.ProductsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.ProductsResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsCategoriesRepository;
import ua.in.bibi.ecommerceonlineshopping.repository.ProductsRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.ProductsSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsCategoriesRepository productsCategoriesRepository;

//    @Autowired
//    private ProductsCategoriesService productsCategoriesService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private BrandsService brandsService;


    //    create
    public ProductsResponse create(ProductsRequest productRequest) throws WrongInputException {
        Products product = new Products();
        product.setName(productRequest.getName());
        product.setBrand(brandsService.findOne(productRequest.getBrandId()));
//        product.setCategory(categoriesService.getPetType());
//        productsCategoriesRepository.getOne()
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

    public DataResponse<ProductsResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Products> productsPage;
        if (value != null && !value.equals("")) {
            ProductsSpecification specification = new ProductsSpecification(value);
            productsPage = productsRepository.findAll(specification, pageRequest);
        } else {
            productsPage = productsRepository.findAll(pageRequest);
        }
        return new DataResponse<ProductsResponse>(productsPage.stream().map(ProductsResponse::new).collect(Collectors.toList()), productsPage);
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

    @Transactional
    public ProductsResponse findOneById(Long id) {
        Optional<Products> productsOptional = productsRepository.findById(id);
        if (productsOptional.isPresent()) {
            return new ProductsResponse(productsOptional.get());
        } else {
            throw new IllegalArgumentException("Products with id " + id + " not found");
        }
    }


    private Products productRequestToProducts(Products product, ProductsRequest request) throws WrongInputException {
        if (product == null) {
            product = new Products();
        }
        product.setName(request.getName());
        product.setBrand(brandsService.findOne(request.getBrandId()));
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
