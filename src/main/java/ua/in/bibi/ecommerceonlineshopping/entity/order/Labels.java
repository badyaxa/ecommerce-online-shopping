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
@Table(name = "order_labels")
public class Labels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Label name must not be empty")
    private String name;// not null

    private String color;// not null

    private Integer position;
}