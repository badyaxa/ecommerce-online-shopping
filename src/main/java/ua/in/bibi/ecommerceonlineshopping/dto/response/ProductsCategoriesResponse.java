package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;
import ua.in.bibi.ecommerceonlineshopping.entity.ProductsCategories;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ProductsCategoriesResponse {

    private String categoryName;

//    private Long productId;

    public ProductsCategoriesResponse(ProductsCategories productsCategories) {
        this.categoryName = productsCategories.getCategory().getName();
    }

}
