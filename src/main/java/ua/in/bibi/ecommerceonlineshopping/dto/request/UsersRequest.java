package ua.in.bibi.ecommerceonlineshopping.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UsersRequest {

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(1)
    private Long groupId;
}
