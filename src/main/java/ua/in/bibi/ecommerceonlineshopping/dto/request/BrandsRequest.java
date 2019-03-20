package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class BrandsRequest {

    @NotBlank
    @Size(min = 3, max = 16)
    private String name;

}
