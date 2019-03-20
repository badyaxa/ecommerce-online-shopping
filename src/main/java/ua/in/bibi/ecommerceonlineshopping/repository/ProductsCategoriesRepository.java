package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.ProductsCategories;

@Repository
public interface ProductsCategoriesRepository extends
        /*CrudRepository<Brands, Long> , */
        JpaRepository<ProductsCategories, Long>, JpaSpecificationExecutor<ProductsCategories> {
}