package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "variants_t")
public class Variants {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Products product;

    private String sku;// not null

//    @NotBlank(message = "User name must not be empty")
    private String name;// not null

    @Min(value = 0, message = "Product price must be non-negative value")
    private Integer price;

    private Integer comparePrice;

    @Min(value = 0, message = "Product unit must be non-negative value")
    private Integer stock;

    private Integer position;

    private String attachment;

}
