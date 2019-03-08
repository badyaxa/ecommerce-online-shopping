package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    private String name;// not null

    private Integer price;

    private Integer comparePrice;

    private Integer stock;

    private Integer position;

    private String attachment;

}
