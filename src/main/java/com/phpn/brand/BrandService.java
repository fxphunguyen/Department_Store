package com.phpn.brand;

import com.phpn.brand.dto.BrandParam;
import vn.fx.qh.sapo.entities.product.*;

public interface BrandService {
    Brand create (BrandParam brandParam);
}
