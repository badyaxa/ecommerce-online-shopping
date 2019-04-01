package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_cart")
public class ShoppingCarts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private BigDecimal GrandTotal;


//    @OneToMany(mappedBy = "userShoppingCart", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
//    @JsonIgnore
//    private List<CartItems> userShoppingCartItems;

    @OneToMany(mappedBy = "shoppingCarts", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @NotNull
    private List<CartItems> userShoppingCartItems;


//    @OneToOne(cascade = CascadeType.ALL)
//    private Users user;

    @OneToOne
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private Users user;


//    @ManyToOne
//    @JoinColumn(name = "discount_id")
//    private Discount cartDiscount;

//@Column(name = "total_price")
//@NotNull
//private Float totalPrice;

//@Column(name = "total_cargo_price")
//@NotNull
//private Float totalCargoPrice;

//@Column(name = "date_created", insertable = false)
//@JsonIgnore
//private Date dateCreated;


}

