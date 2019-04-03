package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter @Setter
public class SortRequest {

    private Sort.Direction direction;

    private String field;

}
