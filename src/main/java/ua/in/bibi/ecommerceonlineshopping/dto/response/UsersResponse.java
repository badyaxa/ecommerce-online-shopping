package ua.in.bibi.ecommerceonlineshopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.Users;

@Getter
@Setter
@NoArgsConstructor
public class UsersResponse {
    private Long id;
    private String name;
    private String email;

    public UsersResponse(Users user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}