package com.phpn.product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.phpn.product.dto.ProductResult;
import com.phpn.product.dto.ProductShortParam;

import com.phpn.product.dto.ProductCreate;
import com.phpn.product.dto.ProductWithImageParam;
import com.phpn.product.item.ItemRepository;
import com.phpn.product.item.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.fx.qh.sapo.entities.product.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ItemService itemService;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    Integer productId = product.getId();
                    ProductResult dto = productMapper.toDTO(product);
                    dto.setTotalInventory(itemService.getTotalInventoryQuantityByProductId(productId));
                    dto.setAvailableInventory(itemService.getAvailableInventoryQuantityByProductId(productId));
                    return dto;
                })
                .collect(Collectors.toList());

    }


    @Override
    @Transactional(readOnly = true)
    public ProductResult findById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productMapper.toDTO(productOptional.get());
    }

    @Override
    public List<ProductResult> findAllProductByDeleted(boolean deleted) {
        return null;
    }

    @Override
    public ProductResult findByIdProduct(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public ProductResult create(ProductWithImageParam productWithImageParam) {
        Product product = productRepository.save(productMapper.toModel(productWithImageParam));
        return productMapper.toDTO(product);
    }


    @Override
    @Transactional

    public ProductResult createShortProduct(ProductShortParam productShortParam) {
        Product product = productMapper.toModel(productShortParam);
        product.setImage("");
        product.setStatus(ProductStatus.AVAILABLE);
        product.setDescription("");
        product.setUnit("");
        product.setBarCode("");
        product.setWholesalePrice(new BigDecimal(Integer.parseInt(productShortParam.getRetailPrice())));
        product.setBrandId(1);
        product.setApplyTax(false);
        product.setCreateAt(Instant.now());

        Product p = productRepository.save(product);

        Item item = new Item();
//        item.setProduct(product);
        item.setProductId(p.getId());
        item.setQuantity(Integer.parseInt(productShortParam.getQuantity()));
        item.setAvailable(Integer.parseInt(productShortParam.getQuantity()));
        item.setPrice(new BigDecimal(Integer.parseInt(productShortParam.getImportPrice())));

        //   itemRepository.save(item);

        return productMapper.toDTO(product);
//
//        String fileType = productCreate.getFile().getContentType();
//
//        assert fileType != null;
//
//        fileType = fileType.substring(0, 5);
//
//        productCreate.setFileType(fileType);
//
//        Product product = productRepository.save(productMapper.toProduct(productCreate));
//
//        return product;
//        return  null;
    }


    @Override
    public Product createProduct(ProductCreate productCreate) {
        return null;
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<ProductResult> getAllProductListResult() {
////        List<ProductResult> products=new ArrayList<>();
//        List<Product> entities = productRepository.findAll();
////        for (Product product : entities) {
////            products.add(  productMapper.toDTO(product));
////        }
////        return products;
//
//        return entities.stream().map(
//                entity -> {
//                    ProductResult dto = productMapper.toDTO(entity);
//                    // int ton = itemRepository.store();
//                    //   dto.setTon(ton);
//                    return dto;
//                }).collect(Collectors.toList());
//
//    }


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}