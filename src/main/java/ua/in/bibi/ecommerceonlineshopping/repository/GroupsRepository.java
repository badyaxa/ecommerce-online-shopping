package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Groups;
import ua.in.bibi.ecommerceonlineshopping.entity.Groups;

@Repository
public interface GroupsRepository extends
        /*CrudRepository<Groups, Long> , */
        JpaRepository<Groups, Long>, JpaSpecificationExecutor<Groups> {
}
