package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "users_t")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;// not null

    @Column(name = "password")
    @NotBlank
    private String password;// not null

    @Column(name = "name")
    @NotBlank(message = "User name must not be empty")
    private String name;// not null

    @OneToOne
    private Groups group;  // not null

    @Column(name = "enabled")
    private Boolean enabled;// not null  TINYINT

    @Column(name = "last_ip")
    private String lastIp;

    //private String created  CURRENT_TIMESTAMP;


}
