package com.axon.query.controller;

import com.axon.query.FindProductQuery;
import com.axon.query.model.ProductResModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductQueryController {

    @Autowired
    QueryGateway gateway;

    @GetMapping
    public List<ProductResModel> getAllProducts(){
        FindProductQuery findProductQuery = new FindProductQuery();
        return gateway
                .query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductResModel.class))
                .join();
    }
}
