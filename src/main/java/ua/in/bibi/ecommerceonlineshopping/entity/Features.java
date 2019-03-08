package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "features_t")
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;// not null


    private Boolean in_filter;// not null default 0


    private Integer position;// not null default 0


//    @OneToOne
//    private Optionsz option;

//    @NotNull

//    @ManyToMany
//    private List<Categories> categories = new ArrayList<>();


}
