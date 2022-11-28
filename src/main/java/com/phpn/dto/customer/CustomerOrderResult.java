package com.phpn.dto.customer;

import com.phpn.dto.locationRegion.LocationRegionResult;
import lombok.*;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerOrderResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private Integer locationRegionId;

    private LocationRegionResult locationRegionResult;

    private Integer employeeId;


}

