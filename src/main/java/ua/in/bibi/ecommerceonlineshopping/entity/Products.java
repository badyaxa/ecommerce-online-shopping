package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "products_t")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;// not null

    @ManyToOne
    private Brands brand;

    private String name;// not null

    @OneToMany(mappedBy = "product")
    private List<Images> image = new ArrayList<>();

//    @OneToOne
//    private Optionsz option;


//    @Autowired


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
