package com.example.backend.services.product;

import com.example.backend.entities.ProductColor;
import com.example.backend.entities.ProductDetail;
import com.example.backend.repositories.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailImp implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail insertOne(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    @Override
    public boolean deleteOne(int id) {
        ProductDetail pc = productDetailRepository.findById(id).get();
        if (pc != null) {
            productDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
