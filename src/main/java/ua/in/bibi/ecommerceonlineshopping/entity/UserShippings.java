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
@Table(name = "user_shippings")
public class UserShippings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userShippingName;

    private String userShippingStreet1;

    private String userShippingStreet2;

    private String userShippingCity;

    private String userShippingState;

    private String userShippingCountry;

    private String userShippingZipcode;

    private boolean userShippingDefault;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
