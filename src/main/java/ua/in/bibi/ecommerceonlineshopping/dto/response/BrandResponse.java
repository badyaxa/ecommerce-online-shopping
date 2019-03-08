package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;

@Getter
@Setter
@NoArgsConstructor
public class BrandResponse {
    private Long id;
    private String name;

    public BrandResponse(Brands brands) {
        id = brands.getId();
        name = brands.getName();
    }
}
