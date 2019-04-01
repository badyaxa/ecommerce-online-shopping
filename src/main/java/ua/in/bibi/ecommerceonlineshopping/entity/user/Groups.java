package ua.in.bibi.ecommerceonlineshopping.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.in.bibi.ecommerceonlineshopping.entity.user.Users;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "user_groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Group name must not be empty")
    private String name;// not null

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Users> user = new ArrayList<>();

    @Min(0)
    @Max(99)
    private Integer discount;// not null default 0
}
