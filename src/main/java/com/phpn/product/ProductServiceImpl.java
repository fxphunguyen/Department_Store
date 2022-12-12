package com.phpn.product;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.phpn.category.CategoryRepository;
import com.phpn.exceptions.AppNotFoundException;
import com.phpn.media.MediaMapper;
import com.phpn.media.MediaResult;
import com.phpn.media.MediaService;
import com.phpn.product.dto.*;

import com.phpn.product.item.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.fx.qh.sapo.entities.media.Media;
import vn.fx.qh.sapo.entities.product.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    MediaMapper mediaMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    MediaService mediaService;

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
        if (productOptional.isPresent()) {
            return productMapper.toDTO(productOptional.get());
        }
        else {
            return null;
        }
    }

    @Override
    public List<ProductResult> findAllProductByDeleted(boolean deleted) {
        return null;
    }

    @Override
    public ProductResult findByIdProduct(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public ProductResult create(CreateProductParam productWithImageParam) {
        Product product = productMapper.toModel(productWithImageParam);
        product.setId(0);
        if (productWithImageParam.getEnableSell() == true) {
            product.setStatus(ProductStatus.parseProductStatus("AVAILABLE"));
        }
        else {
            product.setStatus(ProductStatus.parseProductStatus("UNAVAILABLE"));
        }
        System.out.println(product);
        ProductResult productResult = productMapper.toDTO(productRepository.save(product));
        ItemResult itemResult = itemService.create(itemMapper.toDTO(productWithImageParam, productResult));
        System.out.println(productResult);
        System.out.println(itemResult);
        List<MediaResult> mediaResults = mediaService.save(productWithImageParam.getMediaList(), productResult.getId());

        System.out.println(mediaResults);
        return productResult;
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


        Product p = productRepository.save(product);

        Item item = new Item();
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

    @Override
    public Page<Product> findAllByTitleContaining(String title, Pageable pageable) {
        return productRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    @Transactional
    public Map<String, Object> getAllProductItemPage(Integer pageNo, Integer pageSize, String title) {
        pageNo = pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products;
        if(!title.equals("0") ){
            products = productRepository.findAllByTitleContaining(title, pageable);
        } else {
            products = productRepository.findAll(pageable);
        }
        if(products.hasContent()){
            List<Product> productList = products.getContent();
            List<ProductItemResult> productItemResults = new ArrayList<>();
            for(Product product : productList){
                ProductItemResult productItemResult = productMapper.toDTOPage(product);
                productItemResult.setInventory(itemService.getTotalInventoryQuantityByProductId(product.getId()));
                productItemResult.setAvailable(itemService.getAvailableInventoryQuantityByProductId(product.getId()));
                productItemResults.add(productItemResult);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("products", productItemResults);
            response.put("totalItem", products.getTotalElements());
            response.put("totalPage", products.getTotalPages());
            return response;
        } else {
            return new HashMap<>();
        }
    }

    //dang chỉnh

    @Override
    @Transactional
    public Map<String, Object> getAllProductItemPageByCategoryContaining(Integer pageNo, Integer pageSize, Integer categoryId) {
        pageNo = pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Category category = categoryRepository.findById(categoryId).get();
        Page<Product> products = productRepository.findAllByCategoryContainingAndTitleContaining(1,"ao", pageable);
//        if(!title.equals("0") ){
//            products = productRepository.findAllByTitleContaining(title, pageable);
//        } else {
//            products = productRepository.findAll(pageable);
//        }
        if(products.hasContent()){
            List<Product> productList = products.getContent();
            List<ProductItemResult> productItemResults = new ArrayList<>();
            for(Product product : productList){
                ProductItemResult productItemResult = productMapper.toDTOPage(product);
                productItemResult.setInventory(itemService.getTotalInventoryQuantityByProductId(product.getId()));
                productItemResult.setAvailable(itemService.getAvailableInventoryQuantityByProductId(product.getId()));
                productItemResults.add(productItemResult);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("products", productItemResults);
            response.put("totalItem", products.getTotalElements());
            response.put("totalPage", products.getTotalPages());
            return response;
        } else {
            return new HashMap<>();
        }
    }

}