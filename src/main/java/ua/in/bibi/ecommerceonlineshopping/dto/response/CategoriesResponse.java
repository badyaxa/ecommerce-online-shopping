package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.category.Categories;

@Getter
@Setter
@NoArgsConstructor
public class CategoriesResponse {

    private Long parentId;

    private Long id;

    private String name;

    public CategoriesResponse(Categories category) {
        this.parentId = category.getParentId();
        this.id = category.getId();
        this.name = category.getName();
    }
}
