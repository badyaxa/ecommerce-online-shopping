package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;

@Repository
public interface CategoriesRepository extends /*CrudRepository<Brands, Long> , */
        JpaRepository<Categories, Long>, JpaSpecificationExecutor<Categories> {
}