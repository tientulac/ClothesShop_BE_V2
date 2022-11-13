package com.example.backend.services.product;

import com.example.backend.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product updateOne(Product Product);
    Product insertOne(Product Product);
    Product findById(int id);
    boolean deleteOne(int id);
}
