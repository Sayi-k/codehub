package com.axon.query;

import com.axon.core.data.ProductEntity;
import com.axon.core.data.ProductRepository;
import com.axon.query.model.ProductResModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductQueryHandler {

    @Autowired
    ProductRepository repository;

    @QueryHandler
    public List<ProductResModel> on(FindProductQuery findProductQuery){
        List<ProductEntity> entity = repository.findAll();
        return entity.stream().map(this::buildProductResModel).collect(Collectors.toList());
    }

    private ProductResModel buildProductResModel(ProductEntity entity) {
        return ProductResModel.builder()
                .productId(entity.getProductId())
                .name(entity.getName())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }
}
