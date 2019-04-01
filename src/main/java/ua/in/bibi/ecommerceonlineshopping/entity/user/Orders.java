package ua.in.bibi.ecommerceonlineshopping.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.order.PaymentMethods;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;

    private Date shippingDate;

    private String shippingMethod;

    private String orderStatus;

    private BigDecimal orderTotal;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItems> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private BillingAddress billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentMethods payment;

    @ManyToOne
    private Users user;


//    @OneToOne
//    private Delivery delivery;

    //    @NotNull
//    private Integer delivery_price;// not null default 0

//    private Boolean paid;// not null default 1

//    private Boolean closed;// not null default 1

//@Temporal — применяется к полям или свойствам с типом java.util.Date и java.util.Calendar. Например, если в БД время сохраняется как sql.Date, то чтобы использовать дату из java.util.Date указываем эту аннотацию.
//@Temporal(TemporalType.DATE)
//@Column(name = "BIRTH_DATE")

    //    private Date datetime;
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate dateCreated;


//    private String name;// not null
//    private String address;// not null
//    private String phone;// not null

//    @Email
//    private String email;// not null
//    private String comment;// not null
//    private Integer status;// not null default 0
//    private Float total_price;// not null default 0

//    private String ip;// not null


    //    private parent_id;// not null  default 0
//    private Boolean visible;// not null default 1

//    @ManyToMany
//    private List<Features> features = new ArrayList<>();

//    @Enumerated(EnumType.STRING)
//    private OrdersLabels ordersLabels;

}
