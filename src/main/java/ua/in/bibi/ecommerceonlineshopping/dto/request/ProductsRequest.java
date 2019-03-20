package ua.in.bibi.ecommerceonlineshopping.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ProductsRequest {

    @NotNull
    private String name;

    private Long idCategory;

    private Long idBrand;

//    private Double volume;
}
