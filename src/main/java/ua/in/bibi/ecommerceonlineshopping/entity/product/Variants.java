package ua.in.bibi.ecommerceonlineshopping.entity.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.product.Products;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "product_variants")
public class Variants {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Products product;

    @Column(name = "sku")
    @NotBlank
    private String sku;// not null

//    @NotBlank(message = "User name must not be empty")
    private String name;// not null


    @Column(name = "price")
    @Min(value = 0, message = "Product price must be non-negative value")
    private Integer price;

    private Integer comparePrice;

    @Column(name = "stock")
    @NotNull
    @Min(value = 0, message = "Product unit must be non-negative value")
    private Integer stock;

    private Integer position;

    private String attachment;

}
