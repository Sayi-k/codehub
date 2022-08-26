package com.axon.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookupEntity, String> {
    public ProductLookupEntity findByProductIdOrName(String productId, String name);
}
