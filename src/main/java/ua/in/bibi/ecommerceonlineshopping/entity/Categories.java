package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "categories_t")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Category name must not be empty")
    private String name;// not null


//    private parent_id;// not null  default 0

//    @Column(name = "meta_title")
//    private String categoryMetaTitle;// not null
//    private String categoryMetaKeywords;// not null
//    private String categoryMetaDescription;// not null
//    private String categoryDescription;// not null
//    private String categoryUrl;// not null
//    private String categoryImage;// not null
//
//    private Integer categoryPosition;// not null default 0
//    private Boolean categoryVisible;// not null default 1


//    @NotNull

//    @ManyToMany
//    private List<Features> features = new ArrayList<>();
//
//    @ManyToMany
//    private List<Products> products = new ArrayList<>();

}
