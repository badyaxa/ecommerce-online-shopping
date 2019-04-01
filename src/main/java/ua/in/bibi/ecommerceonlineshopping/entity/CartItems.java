package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_cart_item")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int qty;

    private BigDecimal subTotal;

    @OneToOne
    private Products product;

    @OneToMany(mappedBy = "cartItem")
//    @JsonIgnore
    private List<ProductToCartItem> productToCartItemList;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCarts shoppingCarts;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;


//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "cart_id")
//    @JsonIgnoreProperties("cartItemList") //Prevents infinite recursion
//    @JsonIgnore
//    private ShoppingCarts userShoppingCart;

//    @ManyToOne //TODO one to many ??? many to many????
//    @JoinColumn(name = "product_id")
//    private ProductDisplay cartProduct;

//    @Column(name = "amount")
//    private Integer amount;

}
