package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;

@Repository
public interface UsersRepository extends
        /*CrudRepository<Brands, Long> , */
        JpaRepository<Users, Long>, JpaSpecificationExecutor<Users> {

//    Users findByEmail(String email);
}
