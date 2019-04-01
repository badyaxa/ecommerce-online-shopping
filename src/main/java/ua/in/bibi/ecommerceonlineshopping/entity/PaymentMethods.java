package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payment_methods")
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String module;// not null

//    @NotBlank(message = "PaymentMethod name must not be empty")
//    private String name;// not null

//    private String description;// not null

//    @OneToOne
//    private Currencies currency;// not null
//    private String settings;// not null

//    private Boolean enabled;// not null default 1
//    private Integer position;// not null

//    @ManyToMany
//    private List<Delivery> deliveries = new ArrayList<>();

}
