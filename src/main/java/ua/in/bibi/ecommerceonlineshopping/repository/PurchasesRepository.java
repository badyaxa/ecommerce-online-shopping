package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.user.Purchases;

@Repository
public interface PurchasesRepository extends CrudRepository<Purchases, Long> {
}
