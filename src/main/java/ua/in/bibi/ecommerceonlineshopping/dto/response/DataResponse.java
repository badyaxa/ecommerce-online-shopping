package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {

    private List<T> content;

    private Integer totalPages;

    private Long totalElements;


    public DataResponse(List<T> data, Page page) {
        this.content = data;
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
}
