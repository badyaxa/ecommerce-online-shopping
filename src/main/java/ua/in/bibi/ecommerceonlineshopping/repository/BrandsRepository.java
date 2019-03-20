package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;

@Repository
public interface BrandsRepository extends /*CrudRepository<Brands, Long> , */
        JpaRepository<Brands, Long>, JpaSpecificationExecutor<Brands> {
}
