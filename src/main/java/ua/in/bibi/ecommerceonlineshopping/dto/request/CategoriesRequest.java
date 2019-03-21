package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoriesRequest {

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(0)
    private Long parentId;
}
