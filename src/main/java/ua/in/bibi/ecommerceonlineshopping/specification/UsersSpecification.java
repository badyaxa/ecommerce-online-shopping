package ua.in.bibi.ecommerceonlineshopping.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.in.bibi.ecommerceonlineshopping.entity.user.Users;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UsersSpecification implements Specification<Users> {

    private String value;

    public UsersSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Users> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }

    private Predicate findByEmail(Root<Users> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("email"), value);
    }

//    private Predicate findByLastName(Root<Users> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }


    @Override
    public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
//                findByFirstName(root, criteriaBuilder),
                findByName(root, criteriaBuilder),
                findByEmail(root, criteriaBuilder)
        );
    }
}
