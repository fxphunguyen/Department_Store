package com.phpn.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
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

    private String address;

    private String wardName;

    private String districtName;

    private String provinceName;

    private Boolean deleted;

    public CustomerResult(String name, String phone, Boolean deleted) {
        this.name = name;
        this.phone = phone;
        this.deleted = deleted;
    }

    public CustomerResult(Integer id, String customerCode, String name, String phone, String customerGroup, String email,
                          String birthday, String status, String createAt, String updateAt, String address, String wardName,
                          String districtName, String provinceName) {
        this.id = id;
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.customerGroup = customerGroup;
        this.email = email;
        this.birthday = birthday;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.address = address;
        this.wardName = wardName;
        this.districtName = districtName;
        this.provinceName = provinceName;

    }

    //
//    private String totalSpending;
}

