package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_payments")
public class UserPayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String cardName;

    private String cardNumber;

    private int expiryMonth;

    private int expiryYear;

    private int cvc;

    private String holderName;

    private boolean defaultPayment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "payment")
    private UserBillings userBilling;
}
