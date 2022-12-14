package com.phpn.brand;

import com.phpn.brand.dto.BrandParam;
import com.phpn.brand.dto.BrandResult;
import vn.fx.qh.sapo.entities.product.*;

import java.util.List;

public interface BrandService {
    Brand create (BrandParam brandParam);
    List<BrandResult>findAll();
}
