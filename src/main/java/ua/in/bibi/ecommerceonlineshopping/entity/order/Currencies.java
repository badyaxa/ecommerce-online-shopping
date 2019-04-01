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
@Table(name = "payment_method_currencies")
public class Currencies {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Currency name must not be empty")
    private String name;// not null

}
