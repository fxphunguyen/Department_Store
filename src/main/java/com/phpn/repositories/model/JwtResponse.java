package com.phpn.repositories.model;

import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JwtResponse {

    private Integer id;
    private String token;
    private String type = "Bearer";
    private String email;
    private String name;

}