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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO, SEQUENCE, TABLE
    private Long id;

//    @Column(nullable = false)
    private String url;// not null

    @ManyToOne
    private Brands brand;

    @NotBlank(message = "Product name must not be empty")
    @Column(nullable = false, unique = true)
//    @NotNull
    @Size(min = 3, max = 50)
//    @Column(name = "name")
    private String name;// not null

    @OneToMany(mappedBy = "product")
    private List<Images> imagesList = new ArrayList<>();

//    @OneToOne
//    private Optionsz option;


//    @Autowired
//@Transient   // — указывает, что свойство не нужно записывать.
               // Значения под этой аннотацией не записываются
               // в базу данных (так же не участвуют в сериализации).
               // static и final переменные экземпляра всегда transient.

    //private String annotation;// not null

    private String body;// not null
    private Boolean visible;// not null default 1
    private Integer position;// not null
    private String meta_title;// not null
    private String meta_keywords;// not null
    private String meta_description;// not null


//    @ManyToMany
//    private List<Categories> categories = new ArrayList<>();


}
