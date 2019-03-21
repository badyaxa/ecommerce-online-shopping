package ua.in.bibi.ecommerceonlineshopping.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.in.bibi.ecommerceonlineshopping.entity.ProductsCategories;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductsCategoriesSpecification implements Specification<ProductsCategories> {

    private Long categoryId;

    private Long productId;


    //    private String value;

//    public ProductsCategoriesSpecification(String value) {
//        this.value = value;
//    }

    private Predicate findByCategoryId(Root<ProductsCategories> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("category_id"), categoryId);
    }

    private Predicate findByBrandId(Root<ProductsCategories> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("product_id"), productId);
    }

//    private Predicate findByFirstName(Root<Products> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("firstName"), value);
//    }

//    private Predicate findByLastName(Root<Products> root, CriteriaBuilder criteriaBuilder){
//        return criteriaBuilder.like(root.get("lastName"), value);
//    }

    @Override
    public Predicate toPredicate(Root<ProductsCategories> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(
                findByCategoryId(root, criteriaBuilder),
                findByBrandId(root, criteriaBuilder)
        );
    }


//    @Override
//    public Predicate toPredicate(Root<ProductsCategories> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.or(
////                findByFirstName(root, criteriaBuilder),
////                findByLastName(root,criteriaBuilder)
//                findByName(root, criteriaBuilder)
//        );
//    }
}
