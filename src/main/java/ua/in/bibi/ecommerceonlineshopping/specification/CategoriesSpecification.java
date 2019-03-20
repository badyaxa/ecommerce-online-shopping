package ua.in.bibi.ecommerceonlineshopping.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.in.bibi.ecommerceonlineshopping.entity.Categories;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CategoriesSpecification implements Specification<Categories> {

    private String value;

    public CategoriesSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Categories> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }

//    private Predicate findByFirstName(Root<Categories> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("firstName"), value);
//    }

//    private Predicate findByLastName(Root<Categories> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }


    @Override
    public Predicate toPredicate(Root<Categories> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
//                findByFirstName(root, criteriaBuilder),
//                findByLastName(root,criteriaBuilder)
                findByName(root, criteriaBuilder)
        );
    }
}
