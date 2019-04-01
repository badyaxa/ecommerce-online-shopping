package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "category_features")
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Features name must not be empty")
    private String name;// not null


    private Boolean in_filter;// not null default 0


    private Integer position;// not null default 0


//    @OneToOne
//    private Optionsz option;

//    @NotNull

    @ManyToMany/*(mappedBy = "features")*/
    private List<Categories> categories = new ArrayList<>();


}
