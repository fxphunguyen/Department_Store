package com.phpn.dto.customer;

import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.CustomerGroup;
import com.phpn.repositories.model.LocationRegion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private CustomerGroup customerGroup;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer locationRegionId;

    private CustomerGender customerGender;

    private Integer employeeId;
    private Boolean deleted;

    private LocationRegion locationRegion;

    public CustomerResult(String name, String phone, Boolean deleted) {
        this.name = name;
        this.phone = phone;
        this.deleted = deleted;
    }
//
//    private String totalSpending;
}

