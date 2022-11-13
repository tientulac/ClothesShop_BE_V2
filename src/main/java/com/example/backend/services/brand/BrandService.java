package com.example.backend.services.brand;

import com.example.backend.entities.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand updateOne(Brand category);
    Brand insertOne(Brand category);
    Brand findById(int id);
    boolean deleteOne(int id);
}
