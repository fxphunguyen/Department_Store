package com.phpn.dto.item;

import com.phpn.dto.employee.EmployeeRResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ItemRResult extends ItemResult {

    private EmployeeRResult employee;

    private Integer supplierId;

    private Integer orderId;

}
