package com.phpn.brand.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BrandResult {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}