package ua.in.bibi.ecommerceonlineshopping.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "delivery_payment_t")
public class DeliveryPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Delivery delivery;

    @OneToOne
    private PaymentMethods paymentMethod;

}
