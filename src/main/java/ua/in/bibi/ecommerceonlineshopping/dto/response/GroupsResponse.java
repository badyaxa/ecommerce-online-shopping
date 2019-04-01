package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Groups;

@Getter
@Setter
@NoArgsConstructor
public class GroupsResponse {

    private Long id;

    private String name;

    public GroupsResponse(Groups group) {
        this.id = group.getId();
        this.name = group.getName();
    }
}
