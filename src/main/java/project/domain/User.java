package project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "login")
@ToString
public class User {

    private String login;

    @JsonIgnore
    private String passwordHash;

}
