package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @Min(0)
    private Long parent_id;// not null  default 0

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank(message = "Category name must not be empty")
    @Size(min = 3, max = 50)
    private String name;// not null

//    @OneToMany(mappedBy = "category")
//    private List<Products> listProductsByCategory = new ArrayList<>();


//    @ManyToMany
//    @OneToMany(mappedBy = "category")
//    (fetch = FetchType.LAZY) //для лістів
//    (fetch = FetchType.EAGER) //для одиночних
//    @OrderBy("firstName asc") //указание сортировки




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

}
