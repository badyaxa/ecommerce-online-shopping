package ua.in.bibi.ecommerceonlineshopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @Column(name = "name", nullable = false, unique = true)
    @NotBlank(message = "User name must not be empty")
    private String name;// not null
//    private String userName;

    //    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "password")
//    @NotBlank
    private String password;// not null

    private String firstName;

    private String lastName;

    @Email
    @NotBlank
    @Column(name = "email", nullable = false, updatable = false)
    private String email;// not null

    private String phone;

    //    @Column(name = "enabled")
//    private Boolean enabled = true;// not null  TINYINT
    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private ShoppingCarts shoppingCart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRoles> userRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserShippings> userShippingsList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Orders> orderList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPayments> userPaymentsList;


    @ManyToOne
    private Groups group;  // not null


//    @Column(name = "last_ip")
//    private String lastIp;

    //private String created  CURRENT_TIMESTAMP;


}
