package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Features;

@Repository
public interface FeaturesRepository extends
        /*CrudRepository<Brands, Long> , */
        JpaRepository<Features, Long>, JpaSpecificationExecutor<Features> {
}
