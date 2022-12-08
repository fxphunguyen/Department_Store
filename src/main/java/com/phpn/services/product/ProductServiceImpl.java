package com.phpn.services.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.phpn.dto.product.ProductResult;
import com.phpn.dto.product.ProductShortParam;

import com.phpn.dto.product.ProductCreate;
import com.phpn.dto.product.ProductWithImageParam;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.ItemRepository;
import com.phpn.repositories.model.Item;
import com.phpn.repositories.model.Product;
import com.phpn.repositories.ProductRepository;

import com.phpn.repositories.model.ProductStatus;
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
    ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    //    public List<ProductResult> findAll1() {
//        item.findBNyProdcutId
//        return productRepository.findAll()
//                .stream()
//                .map(productMapper :: toDTO)
//                .collect(Collectors.toList());
//    }
    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> showAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toDTO(product))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> findAllProductByDeleted(boolean deleted) {
        return productRepository.findAllProductByDeleted(deleted)
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public ProductResult findByIdProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productMapper.toDTO(productOptional.get());
    }

    @Transactional
    @Override
    public Product create(ProductWithImageParam productWithImageParam) {
        return productRepository.save(productMapper.toModel(productWithImageParam));
    }

//    @Override
//    public Product create(ProductParam productParam) {
//        return productRepository.save(productMapper.toModel(productParam));
//    }


    @Override
    @Transactional

    public Product createShortProduct(ProductShortParam productShortParam) {
        Product product = productMapper.toModel(productShortParam);
        product.setImage("");
        product.setStatus(ProductStatus.AVAILABLE);
        product.setDescription("");
        product.setUnit("");
        product.setBarCode("");
        product.setWholesalePrice(new BigDecimal(Integer.parseInt(productShortParam.getRetailPrice())));
        product.setBrandId(1);
        product.setApplyTax(false);
        product.setDeleted(false);
        product.setCreateAt(java.time.LocalDateTime.now().toString());

        Product p = productRepository.save(product);

        Item item = new Item();
//        item.setProduct(product);
        item.setProductId(p.getId());
        item.setQuantity(Integer.parseInt(productShortParam.getQuantity()));
        item.setAvailable(Integer.parseInt(productShortParam.getQuantity()));
        item.setPrice(new BigDecimal(Integer.parseInt(productShortParam.getImportPrice())));

        itemRepository.save(item);

        return product;
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

    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> getAllProductListResult() {
//        List<ProductResult> products=new ArrayList<>();
        List<Product> entities = productRepository.findAll();
//        for (Product product : entities) {
//            products.add(  productMapper.toDTO(product));
//        }
//        return products;

        return entities.stream().map(
                entity -> {
                    ProductResult dto = productMapper.toDTO(entity);
                   // int ton = itemRepository.store();
                 //   dto.setTon(ton);
                    return dto;
                }).collect(Collectors.toList());

    }

}