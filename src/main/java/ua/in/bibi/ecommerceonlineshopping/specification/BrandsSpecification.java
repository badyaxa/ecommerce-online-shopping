package ua.in.bibi.ecommerceonlineshopping.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.in.bibi.ecommerceonlineshopping.entity.Brands;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BrandsSpecification implements Specification<Brands> {

    private String value;

    public BrandsSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Brands> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }

//    private Predicate findByFirstName(Root<Brands> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("firstName"), value);
//    }

//    private Predicate findByLastName(Root<Brands> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }


    @Override
    public Predicate toPredicate(Root<Brands> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
//                findByFirstName(root, criteriaBuilder),
//                findByLastName(root,criteriaBuilder)
                findByName(root, criteriaBuilder)
        );
    }
}
