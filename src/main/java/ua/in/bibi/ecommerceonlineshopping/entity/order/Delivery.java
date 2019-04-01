package ua.in.bibi.ecommerceonlineshopping.entity.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Delivery name must not be empty")
    private String name;// not null


    private String description;// not null
    private Integer free_from;// not null
    private Integer price;//  not null
    private Boolean enabled;// not null default 1
    private Integer position;// not null default 0
    private Integer separate_payment;//   default 0

//    @NotNull


//    @ManyToMany
//    private List<PaymentMethods> paymentMethods = new ArrayList<>();
}