package com.phpn.dto.locationRegion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class LocationRegionResult {


    private Integer id;

    private Integer provinceId;

    private  String provinceName;

    private Integer districtId;

    private String districtName;

    private  Integer wardId;

    private String wardName;

    private String address;



}
