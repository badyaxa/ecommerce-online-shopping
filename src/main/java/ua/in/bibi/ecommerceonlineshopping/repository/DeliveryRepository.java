package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Delivery;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
