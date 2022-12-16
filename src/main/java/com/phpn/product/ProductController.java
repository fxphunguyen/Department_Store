
package com.phpn.product;

import com.phpn.exceptions.AppNotFoundException;
import com.phpn.product.dto.ProductDetailResult;
import com.phpn.product.dto.ProductResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.fx.qh.sapo.entities.product.Product;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public ModelAndView showProductListPage() {
        return new ModelAndView("/admin/product/product_list");
    }

    @GetMapping("/products/create")
    public ModelAndView showProductCreatePage() {
        return new ModelAndView("/admin/product/product_create");
    }


    @GetMapping("/product/edit/{id}")
    public ModelAndView showProductEditPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        ProductResult product = productService.findById(id);
        if (product == null) {
            modelAndView.addObject("errors", "errors");
        } else {
            modelAndView.addObject("product", productService.findDetailById(product.getId()));
        }
        modelAndView.setViewName("/admin/product/product_edit");
        return modelAndView;
    }

    @GetMapping("/product/{id}")
    public ModelAndView showDetailProduct(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        ProductResult product = productService.findById(id);
        if (product == null) {
            modelAndView.addObject("errors", "errors");
        } else {
            ProductDetailResult productResult =productService.findDetailById(product.getId());
            modelAndView.addObject("product", productResult);
        }
        modelAndView.setViewName("/admin/product/product_detail");
        return modelAndView;
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

    //export excel file
    @GetMapping("/products/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<ProductResult> listProducts = productService.findAll();

        ProductExcelExporter excelExporter = new ProductExcelExporter(listProducts);

        excelExporter.export(response);
    }
//    @PostMapping("/uploadFile")
//    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
//
//        fileService.uploadFile(file);
//
//        redirectAttributes.addFlashAttribute("message",
//                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }

}

