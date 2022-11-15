package com.phpn.dto.customer;


import com.phpn.dto.locationRegion.LocationRegionCreate;
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

    private  String customerGroup;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer employeeId = 2;

    private  Integer locationRegionID;

  private LocationRegionCreate locationReionCreate;



}
