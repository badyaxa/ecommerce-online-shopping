package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "user_purchases")
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Orders order;

    @OneToOne
    private Products product;

    @OneToOne
    private Variants variant;

    private String productName;
    private String variantName;

    private Integer price;
    private Integer amount;
//    private String sku;

}
