package ua.in.bibi.ecommerceonlineshopping.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.in.bibi.ecommerceonlineshopping.entity.product.Products;

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
    @JoinColumn(name = "shopping_cart_id")
    private Cart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "cart_id")
    @JsonIgnoreProperties("cartItemList") //Prevents infinite recursion
    @JsonIgnore
    private Cart userShoppingCart;

//    @ManyToOne //TODO one to many ??? many to many????
//    @JoinColumn(name = "product_id")
//    private ProductDisplay cartProduct;

    @Column(name = "amount")
    private Integer amount;

}
