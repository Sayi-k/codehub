package com.axon.core.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

    @Id
    @Column(unique = true)
    private String productId;
    @Column(unique = true)
    private String name;
    private double price;
    private int quantity;
}
