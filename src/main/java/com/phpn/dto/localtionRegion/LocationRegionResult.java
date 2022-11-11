package com.phpn.dto.localtionRegion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class LocationRegionResult {


    private Integer Id;

    private String address;

    private  Integer wardId;


    private String wardName;


    private Integer districId;

    private String districtName;

    private Integer provinceId;

    private  String provinceName;

}
