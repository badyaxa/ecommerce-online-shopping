package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Products;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String brandName;

    private String name;



//    private Integer year;

//    private Double volume;


    /*
     * or else you can return car with countryResponse
     *
     *
     * private CountryResponse countryResponse;
     */

    public ProductResponse(Products product) {
        id = product.getId();
        brandName = product.getBrand().getName();
        name = product.getName();
//        year = product.getYear();
//        volume = product.getVolume();
    }
}
