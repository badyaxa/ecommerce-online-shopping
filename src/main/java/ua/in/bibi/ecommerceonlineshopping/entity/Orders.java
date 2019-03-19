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
@Table(name = "orders_t")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Delivery delivery;

    //    @NotNull
    private Integer delivery_price;// not null default 0

    @OneToOne
    private PaymentMethods paymentMethod;

    private Boolean paid;// not null default 1

//    private Date time payment_date;

    private Boolean closed;// not null default 1



//@Temporal — применяется к полям или свойствам с типом java.util.Date и java.util.Calendar. Например, если в БД время сохраняется как sql.Date, то чтобы использовать дату из java.util.Date указываем эту аннотацию.
//@Temporal(TemporalType.DATE)
//@Column(name = "BIRTH_DATE")

    //    private Date datetime;
    @OneToOne
    private Users user;// not null

    private String name;// not null
    private String address;// not null
    private String phone;// not null

    @Email
    private String email;// not null
    private String comment;// not null
//    private Integer status;// not null default 0
//    private Float total_price;// not null default 0

    private String ip;// not null


    //    private parent_id;// not null  default 0
//    private Boolean visible;// not null default 1

//    @ManyToMany
//    private List<Features> features = new ArrayList<>();

}
