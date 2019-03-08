package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "brands_t")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    @Size(min = 3, max = 50)
    private String name;// not null

    //    @Qualifier( "id been") // использование уникального для Spring.
    @OneToMany(mappedBy = "brand")
//    (fetch = FetchType.LAZY) //для лістів
//    (fetch = FetchType.EAGER) //для одиночних
    private List<Products> listProductsByBrand = new ArrayList<>();

    private String url;// not null
    private String meta_title;// not null
    private String meta_keywords;// not null
    private String meta_description;// not null
    private String description;// not null
    private String image;// not null

}
