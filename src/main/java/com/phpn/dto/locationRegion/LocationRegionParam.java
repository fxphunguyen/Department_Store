package com.phpn.dto.locationRegion;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class LocationRegionParam {

    private Integer Id;

    private String name;

    private  Integer wardId;

    private String wardName;

    private Integer districId;

    private String districtName;

    private Integer provinceId;

    private  String provinceName;
}
