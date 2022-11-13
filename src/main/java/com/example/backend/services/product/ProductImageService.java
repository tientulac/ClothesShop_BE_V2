package com.example.backend.services.product;

import com.example.backend.entities.Product;
import com.example.backend.entities.ProductImage;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> findAll();
    ProductImage insertOne(ProductImage productImage);
    boolean deleteOne(int id);
}
