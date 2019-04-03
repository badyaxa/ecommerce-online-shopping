package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString(exclude = "product")
@Entity
@Table(name = "product_brands")
public class Brands {

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


//    @NotNull
    @NotBlank(message = "Brand name must not be empty")
    @Size(min = 2, max = 50)
    @Column(name = "name", nullable = false, unique = true)
    private String name;// not null

    //    @Qualifier( "id been") // использование уникального для Spring.
//  @OneToMany(mappedBy=»customer», orphanRemoval=»true»)  //orphanRemoval — позволяет удалять объекты сироты. При удалении родительского объекта удаляется и дочерний.
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
//    (fetch = FetchType.LAZY) //для лістів
//    (fetch = FetchType.EAGER) //для одиночних
//    @OrderBy("name asc") //указание сортировки
    private List<Products> product = new ArrayList<>();

//    @Column(name = "url")
//    private String url;// not null

//    @Column(name = "meta_title")
//    private String metaTitle;// not null
//
//    @Column(name = "meta_keywords")
//    private String brandMetaKeywords;// not null
//
//    @Column(name = "meta_description")
//    private String brandMetaDescription;// not null
//
//    @Column(name = "description")
//    private String brandDescription;// not null
//
//    @Column(name = "image")
//    private String brandImage;// not null

}
