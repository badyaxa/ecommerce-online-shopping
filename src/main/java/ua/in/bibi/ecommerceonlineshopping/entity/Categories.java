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
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Category name must not be empty")
    private String name;// not null


//    private parent_id;// not null  default 0

    private String meta_title;// not null
    private String meta_keywords;// not null
    private String meta_description;// not null
    private String description;// not null
    private String url;// not null
    private String image;// not null

    private Integer position;// not null default 0
    private Boolean visible;// not null default 1


//    @NotNull

//    @ManyToMany
//    private List<Features> features = new ArrayList<>();
//
//    @ManyToMany
//    private List<Products> products = new ArrayList<>();

}
