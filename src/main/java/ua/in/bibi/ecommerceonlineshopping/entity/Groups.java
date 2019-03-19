package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "groups_t")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Group name must not be empty")
    private String name;// not null


//    private Integer discount;// not null default 0
}
