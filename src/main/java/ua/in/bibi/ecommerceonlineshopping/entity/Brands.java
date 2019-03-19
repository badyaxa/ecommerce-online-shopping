package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
//    @NotNull
    @NotBlank(message = "Brand name must not be empty")
    @Size(min = 3, max = 50)
    private String name;// not null

    //    @Qualifier( "id been") // использование уникального для Spring.
//  @OneToMany(mappedBy=»customer», orphanRemoval=»true»)  //orphanRemoval — позволяет удалять объекты сироты. При удалении родительского объекта удаляется и дочерний.
    @OneToMany(mappedBy = "brand")
//    (fetch = FetchType.LAZY) //для лістів
//    (fetch = FetchType.EAGER) //для одиночних
//    @OrderBy("firstName asc") //указание сортировки
    private List<Products> listProductsByBrand = new ArrayList<>();

    @Column(name = "url")
    private String url;// not null

    @Column(name = "meta_title")
    private String metaTitle;// not null

    @Column(name = "meta_keywords")
    private String metaKeywords;// not null

    @Column(name = "meta_description")
    private String metaDescription;// not null

    @Column(name = "description")
    private String description;// not null

    @Column(name = "image")
    private String image;// not null

}
