package ua.in.bibi.ecommerceonlineshopping.entity.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.product.Products;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //    @Min(0)
//    @Column(name = "parent_id", columnDefinition = "default 0")
    private Long parentId;// not null  default 0


    @NotBlank(message = "Category name must not be empty")
    @Size(min = 2, max = 50)
    @Column(name = "name", nullable = false, unique = true)
    private String name;// not null


    @ManyToMany(mappedBy = "category"/*, fetch = FetchType.LAZY*/)
    private List<Products> product = new ArrayList<>();
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    private List<Products> product = new ArrayList<>();

    @ManyToMany(mappedBy = "categories")
    private List<Features> features = new ArrayList<>();

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


}
