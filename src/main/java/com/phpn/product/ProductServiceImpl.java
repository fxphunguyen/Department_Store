package com.phpn.product;

import com.phpn.brand.BrandRepository;
import com.phpn.brand.dto.BrandMapper;
import com.phpn.category.CategoryRepository;
import com.phpn.category.dto.CategoryMapper;
import com.phpn.media.MediaMapper;
import com.phpn.media.MediaResult;
import com.phpn.media.MediaService;
import com.phpn.product.dto.*;
import com.phpn.product.item.ItemMapper;
import com.phpn.product.item.ItemResult;
import com.phpn.product.item.ItemService;
import com.phpn.tax.TaxRepository;
import com.phpn.tax.TaxService;
import com.phpn.tax.dto.TaxMapper;
import com.phpn.tax.dto.TaxResult;
import com.phpn.tax.product_tax.ProductTaxResult;
import com.phpn.tax.product_tax.ProductTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.product.Item;
import vn.fx.qh.sapo.entities.product.Product;
import vn.fx.qh.sapo.entities.product.ProductStatus;
import vn.fx.qh.sapo.entities.product.tax.ProductTax;
import vn.fx.qh.sapo.entities.product.tax.TaxType;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TaxMapper taxMapper;
    MediaMapper mediaMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTaxRepository productTaxRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    TaxRepository taxRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    MediaService mediaService;

    @Autowired
    TaxService taxService;

    @Autowired
    ProductTaxService productTaxService;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResult> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    Integer productId = product.getId();
                    ProductResult dto = productMapper.toDTO(product);
                    List<ProductTax> productTaxSaleList = productTaxRepository.findAllByProductIdAndTaxType(productId, TaxType.TAX_SALE);
                    List<TaxResult> taxSaleList = productTaxSaleList.stream().map(ProductTax::getTax).map(taxMapper::toDTO).collect(Collectors.toList());
                    List<ProductTax> productTaxPurchaseList = productTaxRepository.findAllByProductIdAndTaxType(productId, TaxType.TAX_PURCHASE);
                    List<TaxResult> taxPurchaseList = productTaxPurchaseList.stream().map(ProductTax::getTax).map(taxMapper::toDTO).collect(Collectors.toList());
                    dto.setTaxSaleList(taxSaleList).setTaxPurchaseList(taxPurchaseList);
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
        } else {
            return null;
        }
    }

    @Override
    public ProductDetailResult findDetailById(Integer id) {
        Product product = productRepository.findById(id).get();
        ProductDetailResult productDetailResult = productMapper.toDTODetail(product);

        productDetailResult.setCategory(categoryMapper.toDTO(categoryRepository.findById(product.getCategoryId()).get()));
        productDetailResult.setBrand(brandMapper.toDTO(brandRepository.findById(product.getBrandId()).get()));
//        productDetailResult.setMediaResults(mediaService.findAllById(product.getId()));
        productDetailResult.setItemResult(itemService.findAllByProductId(product.getId()));
        List<ProductTaxResult> productTaxResults = productTaxService.findAllByProductId(product.getId());
        productDetailResult.setTaxResultList(taxService.findAllByProductId(productTaxResults));
        return productDetailResult;
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
        try {
            Product product = productMapper.toModel(productWithImageParam);
            product.setId(0);
            if (productWithImageParam.getEnableSell() == true) {
                product.setStatus(ProductStatus.parseProductStatus("AVAILABLE"));
            } else {
                product.setStatus(ProductStatus.parseProductStatus("UNAVAILABLE"));
            }
            Product productSaved = productRepository.save(product);
            ProductResult productResult = productMapper.toDTO(productSaved);
            ItemResult itemResult = itemService.create(itemMapper.toDTO(productWithImageParam, productResult));
            List<MediaResult> mediaResults = mediaService.save(productWithImageParam.getMediaList(), productSaved);
            List<ProductTaxResult> productTaxResult = productTaxService.create(productWithImageParam.getTaxList(), productSaved);
            System.out.println(productTaxResult);
            return productResult;
        } catch (Exception e) {
            return null;
        }

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

    @Override
    @Transactional
    public Map<String, Object> getAllProductItemPage(Integer pageNo, Integer pageSize, String title, Integer categoryId, Integer brandId, String status) {
        pageNo = pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by("id").descending());
        Page<Product> products;
        if(title.equals("-1") && categoryId == -1 && brandId == -1 && status.equals("-1")){
            products = productRepository.findAll(pageable);

        } else if(categoryId == -1 && brandId == -1 && status.equals("-1")) {
            products = productRepository.findAllByTitleContaining(title, pageable);
        } else if (brandId == -1 && status.equals("-1")) {
            if(title.equals("-1")){
                title = "";
            }
            products = productRepository.findAllByTitleContainingAndCategoryId(categoryId, title, pageable);
        } else if (status.equals("-1")) {
            if(title.equals("-1")){
                title = "";
            }
            products = productRepository.findAllByTitleContainingAndBrandId(brandId, title, pageable);
        } else {
            if(title.equals("-1")){
                title = "";
            }
            products = productRepository.findAllByTitleContainingAndStatus(ProductStatus.parseProductStatus(status), title, pageable);
        }
        if(products.hasContent()){
            List<Product> productList = products.getContent();
            List<ProductItemResult> productItemResults = new ArrayList<>();
            for(Product product : productList){
                ProductItemResult productItemResult = productMapper.toDTOPage(product);
                productItemResult.setImage(mediaService.getLinkMediaByProductIdIsMain(product.getId()));
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
