package com.phpn.dto.customer;


import com.phpn.dto.locationRegion.LocationRegionCreate;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerParam {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

//    private String customerGroup;

//    private String email;

//    private String birthday;

//    private String status;

    private String createAt;

//    private String updateAt;

    private Integer employeeId;

//    private CustomerGender customerGender;

    private Integer locationRegionId;

    private LocationRegionResult locationRegion;

//    private Boolean deleted;


}
