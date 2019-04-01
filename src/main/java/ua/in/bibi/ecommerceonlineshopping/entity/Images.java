package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "product_images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Group name must not be empty")
    private String name;// not null

    @ManyToOne
    private Products product;


//    private String fileName;// not null
//
//    private Integer position;
}


