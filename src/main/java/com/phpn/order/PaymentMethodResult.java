package com.phpn.order;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PaymentMethodResult {

    private Integer id;
    private String title;

}