package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.product.Brands;

@Getter
@Setter
@NoArgsConstructor
public class BrandsResponse {

    private Long id;

    private String name;

    public BrandsResponse(Brands brand) {
        this.id = brand.getId();
        this.name = brand.getName();
    }
}
