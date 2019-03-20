package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class ProductsCategoriesRequest {

    @Positive
    private Long categoryId;

    @Positive
    private Long productId;

}
