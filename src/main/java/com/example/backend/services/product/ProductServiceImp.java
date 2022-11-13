package com.example.backend.services.product;

import com.example.backend.entities.Product;
import com.example.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository ProductRepository;

    @Override
    public List<Product> findAll() {
        return ProductRepository.findAll();
    }

    @Override
    public Product updateOne(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Product insertOne(Product Product) {
        return ProductRepository.save(Product);
    }

    @Override
    public Product findById(int id) {
        return ProductRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Product cate = findById(id);
        if (cate != null) {
            ProductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
