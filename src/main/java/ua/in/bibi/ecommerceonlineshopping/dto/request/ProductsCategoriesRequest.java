package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class ProductsCategoriesRequest {

    @NotNull
//    @Min(1)
    @Positive
    private Long categoryId;


    @NotNull
//    @Min(1)
    @Positive
    private Long productId;

}
