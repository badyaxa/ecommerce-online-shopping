package ua.in.bibi.ecommerceonlineshopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
