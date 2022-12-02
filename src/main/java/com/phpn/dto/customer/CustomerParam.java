package com.phpn.dto.customer;


<<<<<<< HEAD
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.locationRegion.LocationRegionCreate;
import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.LocationRegion;
=======
>>>>>>> phu_dev
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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

<<<<<<< HEAD
    private Integer locationRegionId;

=======
>>>>>>> phu_dev

//    private Boolean deleted;


}
