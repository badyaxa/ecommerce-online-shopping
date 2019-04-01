package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.order.PaymentMethods;

@Repository
public interface PaymentMethodsRepository extends CrudRepository<PaymentMethods, Long> {
}
