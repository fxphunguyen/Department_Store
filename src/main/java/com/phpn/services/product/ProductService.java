package com.phpn.services.product;

import java.util.List;

<<<<<<< HEAD
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductShortParam;
=======
import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductListResult;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductWithImageParam;
>>>>>>> dev_c5
import com.phpn.repositories.model.Product;

public interface ProductService {

    List<ProductResult> findAll();

    List<ProductResult>  showAllProduct();

    List<ProductResult> findAllProductByDeleted(boolean deleted);

    ProductResult findByIdProduct(Integer id);

    Product create(ProductWithImageParam productWithImageParam);

<<<<<<< HEAD
    Product createShortProduct(ProductShortParam productShortParam);
=======
    Product createProduct(ProductCreate productCreate);
    List<ProductListResult> getAllProductListResult();
>>>>>>> dev_c5
}
