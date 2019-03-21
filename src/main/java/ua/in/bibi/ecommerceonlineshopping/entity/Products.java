package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "products_t")
/*@NamedQuery(name = "Car.findByVolume",
        query = "select c from Car c where c.volume between ?1 and ?2")*/
public class Products {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO, SEQUENCE, TABLE
    private Long id;

    @ManyToOne
    private Brands brand;

//    @OneToOne
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    @ManyToMany(mappedBy = "listProductsByCategory")
//    private List<Categories> categoriesList = new ArrayList<>();
//    private Categories category;

    @NotBlank(message = "Product name must not be empty")
    @Column(name = "name", nullable = false, unique = true)
//    @NotNull
    @Size(min = 3, max = 50)
    private String name;// not null


    @OneToMany(mappedBy = "product")
    private List<Images> imagesList = new ArrayList<>();


    //    @Column(nullable = false)
//    private String url;// not null

//    @OneToOne
//    private Optionsz option;


//    @Autowired
//@Transient   // — указывает, что свойство не нужно записывать.
    // Значения под этой аннотацией не записываются
    // в базу данных (так же не участвуют в сериализации).
    // static и final переменные экземпляра всегда transient.

    //private String annotation;// not null

//    private String body;// not null
//    private Boolean visible;// not null default 1
//    private Integer position;// not null
//    private String meta_title;// not null
//    private String meta_keywords;// not null
//    private String meta_description;// not null




}
