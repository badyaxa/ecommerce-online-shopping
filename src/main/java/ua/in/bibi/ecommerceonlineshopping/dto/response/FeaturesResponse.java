package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.category.Features;

@Getter
@Setter
@NoArgsConstructor
public class FeaturesResponse {

    private Long id;

    private String name;

    public FeaturesResponse(Features feature) {
        this.id = feature.getId();
        this.name = feature.getName();
    }
}
