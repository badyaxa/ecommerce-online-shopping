package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "products_categories_t")
public class ProductsCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Products product;
//    private Long productId;

    @OneToOne
    private Categories category;
//    private Long categoryId;

}
