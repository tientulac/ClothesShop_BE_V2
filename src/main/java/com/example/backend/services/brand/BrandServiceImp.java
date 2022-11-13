package com.example.backend.services.brand;

import com.example.backend.entities.Brand;
import com.example.backend.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService{
    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateOne(Brand Brand) {
        return brandRepository.save(Brand);
    }

    @Override
    public Brand insertOne(Brand Brand) {
        return brandRepository.save(Brand);
    }

    @Override
    public Brand findById(int id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Brand cate = findById(id);
        if (cate != null) {
            brandRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
