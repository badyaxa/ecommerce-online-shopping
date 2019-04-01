package ua.in.bibi.ecommerceonlineshopping.entity.user;

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
@Table(name = "user_shipping_address")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String shippingAddressName;

    private String shippingAddressStreet1;

    private String shippingAddressStreet2;

    private String shippingAddressCity;

    private String shippingAddressState;

    private String shippingAddressCountry;

    private String shippingAddressZipcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToOne
    private Orders order;

}
