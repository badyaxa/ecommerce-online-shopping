package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.product.Variants;

@Repository
public interface VariantsRepository extends CrudRepository<Variants, Long> {
}
