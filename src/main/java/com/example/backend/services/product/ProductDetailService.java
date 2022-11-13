package com.example.backend.services.product;

import com.example.backend.entities.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> findAll();
    ProductDetail insertOne(ProductDetail productDetail);
    boolean deleteOne(int id);
}
