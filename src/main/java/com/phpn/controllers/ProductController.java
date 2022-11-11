//package com.phpn.controllers;
//
//import com.phpn.services.product.ProductServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/admin")
//public class ProductController {
//
//    @Autowired
//    private ProductServiceImpl productService;
//
//    //    Điều chỉnh giá vốn
//    @GetMapping("/price_adjustments")
//    public ModelAndView showPriceAdjustmentsPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/product/price_adjustments");
//        return modelAndView;
//    }
//
//    // Nhà cung cấp
//    @GetMapping("/suppliers")
//    public ModelAndView showSupplierPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/product/suppliers");
//        return modelAndView;
//    }
//
//    // Chuyển hàng
//    @GetMapping("/stock_transfers")
//    public ModelAndView showStockTransferPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/product/stock_transfers");
//        return modelAndView;
//    }
//
//
//    // Quản lý kho
//    @GetMapping("/inventory_management")
//    public ModelAndView showInventoryManagementPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/product/inventory_management");
//        return modelAndView;
//    }
//
////    // Kiểm hàng
////    @GetMapping("/stock_adjustments")
////    public ModelAndView showStockAdjustmentPage() {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("/product/stock_adjustments");
////        return modelAndView;
////    }
//
//}