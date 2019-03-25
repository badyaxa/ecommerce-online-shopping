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
@Table(name = "brands")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
//    @NotNull
    @NotBlank(message = "Brand name must not be empty")
    @Size(min = 2, max = 50)
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

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Brands{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
