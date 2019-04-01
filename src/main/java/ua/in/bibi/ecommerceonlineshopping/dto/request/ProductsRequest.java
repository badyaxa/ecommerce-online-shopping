package ua.in.bibi.ecommerceonlineshopping.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class ProductsRequest {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @Positive
    private Long brandId;

    @Positive
    private Long categoryId;


//    private Double volume;
}
