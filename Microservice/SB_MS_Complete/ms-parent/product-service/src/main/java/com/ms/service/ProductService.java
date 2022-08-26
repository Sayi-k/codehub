package com.ms.service;

import com.ms.dto.ProductRequest;
import com.ms.dto.ProductResponse;
import com.ms.entity.Product;
import com.ms.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product savedProduct = productRepository.save(convertToProduct(productRequest));
        log.info("Product {} is saved", savedProduct.getId());
        return convertToProductResponse(savedProduct);
    }

    public List<ProductResponse> getAllProduct(){
        return productRepository.findAll().stream()
                .map(this::convertToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse convertToProductResponse(Product p) {
        return ProductResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .build();
    }

    private Product convertToProduct(ProductRequest req) {
        return Product.builder()
                .name(req.getName())
                .description(req.getDescription())
                .price(req.getPrice())
                .build();
    }
}
