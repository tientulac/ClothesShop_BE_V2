package com.example.backend.services.product;

import com.example.backend.entities.ProductColor;

import java.util.List;

public interface ProductColorService {
    List<ProductColor> findAll();
    ProductColor insertOne(ProductColor productColor);
    boolean deleteOne(int id);
}
