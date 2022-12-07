package com.phpn.services.brand;

import com.phpn.dto.brand.BrandParam;
import com.phpn.repositories.model.Brand;

public interface BrandService {
    Brand create (BrandParam brandParam);
}
