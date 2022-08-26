package com.axon.core.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_lookup")
@NoArgsConstructor
@AllArgsConstructor
public class ProductLookupEntity {

    @Id
    @Column(unique = true)
    private String productId;
    @Column(unique = true)
    private String name;
}
