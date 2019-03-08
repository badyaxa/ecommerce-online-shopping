package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "users_t")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;// not null

    private String password;// not null

    private String name;// not null

    @OneToOne
    private Groups group;  // not null

    private Boolean enabled;// not null  TINYINT

    private String lastIp;

    //private String created  CURRENT_TIMESTAMP;


}
