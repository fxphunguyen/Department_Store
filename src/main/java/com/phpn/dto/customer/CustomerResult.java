package com.phpn.dto.customer;

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

    private String customerGroup;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer locationRegionId;

    private Integer employeeId;
    private Boolean deleted;

    public CustomerResult(String name, String phone, Boolean deleted) {
        this.name = name;
        this.phone = phone;
        this.deleted = deleted;
    }
//
//    private String totalSpending;
}

