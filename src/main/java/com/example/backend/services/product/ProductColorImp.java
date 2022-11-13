package com.example.backend.services.product;

import com.example.backend.entities.Product;
import com.example.backend.entities.ProductColor;
import com.example.backend.repositories.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorImp implements ProductColorService {
    @Autowired
    ProductColorRepository productColorRepository;

    @Override
    public List<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

    @Override
    public ProductColor insertOne(ProductColor productColor) {
        return productColorRepository.save(productColor);
    }

    @Override
    public boolean deleteOne(int id) {
        ProductColor pc = productColorRepository.findById(id).get();
        if (pc != null) {
            productColorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
