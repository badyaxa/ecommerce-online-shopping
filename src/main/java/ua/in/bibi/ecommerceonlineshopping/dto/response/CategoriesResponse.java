package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;

@Getter
@Setter
@NoArgsConstructor
public class CategoriesResponse {

    private Long parentId;

    private Long id;

    private String name;

    public CategoriesResponse(Categories categories) {
        this.parentId = categories.getParent_id();
        this.id = categories.getId();
        this.name = categories.getName();
    }
}
