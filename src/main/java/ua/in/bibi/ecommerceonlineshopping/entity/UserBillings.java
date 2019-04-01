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
@Table(name = "user_billings")
public class UserBillings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userBillingName;

    private String userBillingStreet1;

    private String userBillingStreet2;

    private String userBillingCity;

    private String userBillingState;

    private String userBillingCountry;

    private String userBillingZipcode;

    @OneToOne(cascade = CascadeType.ALL)
    private Payments payment;

}
