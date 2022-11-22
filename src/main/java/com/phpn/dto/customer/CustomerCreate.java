package com.phpn.dto.customer;


import com.phpn.dto.locationRegion.LocationRegionCreate;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.CustomerGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerCreate {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private CustomerGroup customerGroup;

    private String email;

    private String birthday;

    private CustomerGender customerGender;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer employeeId;

    private  Integer locationRegionId;

  private LocationRegionCreate locationRegionCreate;

  private  boolean deleted;



}
