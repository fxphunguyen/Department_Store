package vn.fx.qh.sapo.entities;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class JwtResponse {

    private Integer id;
    private String token;
    private String type = "Bearer";
    private String email;
    private String name;

    public JwtResponse(String token, Integer id, String email, String name) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.name = name;
    }

}