
package com.phpn.product;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ProductController {


    @GetMapping("/products")
    public ModelAndView showProductListPage() {
        return new ModelAndView("/admin/product/product_list");
    }

    @GetMapping("/products/create")
    public ModelAndView showProductCreatePage() {
        return new ModelAndView("/admin/product/product_create");
    }

    @GetMapping("/products/edit")
    public ModelAndView showProductDetailPage() {

        return new ModelAndView("/admin/product/product_detail");
    }


    //    Điều chỉnh giá vốn
    @GetMapping("/price_adjustments")
    public ModelAndView showPriceAdjustmentsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/product/price_adjustments");
        return modelAndView;
    }

    // Chuyển hàng
    @GetMapping("/stock_transfers")
    public ModelAndView showStockTransferPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/product/stock_transfers");
        return modelAndView;
    }


    // Quản lý kho
    @GetMapping("/inventory_management")
    public ModelAndView showInventoryManagementPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/product/inventory_management");
        return modelAndView;
    }

}

