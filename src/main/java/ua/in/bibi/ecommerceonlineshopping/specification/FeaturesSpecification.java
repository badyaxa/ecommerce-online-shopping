package ua.in.bibi.ecommerceonlineshopping.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.in.bibi.ecommerceonlineshopping.entity.Features;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class FeaturesSpecification implements Specification<Features> {

    private String value;

    public FeaturesSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Features> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }

//    private Predicate findByFirstName(Root<Features> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("firstName"), value);
//    }

//    private Predicate findByLastName(Root<Features> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }


    @Override
    public Predicate toPredicate(Root<Features> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
//                findByFirstName(root, criteriaBuilder),
//                findByLastName(root,criteriaBuilder)
                findByName(root, criteriaBuilder)
        );
    }
}
