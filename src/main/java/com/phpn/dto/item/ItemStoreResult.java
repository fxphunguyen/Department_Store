package com.phpn.dto.item;

import com.phpn.dto.product.ProductItemResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ItemStoreResult {
    private Integer id;
    private ProductItemResult product;
    private Integer available;
    private Integer trading;
}
