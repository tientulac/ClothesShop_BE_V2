package com.example.backend.services.category;

import com.example.backend.entities.Category;
import com.example.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category insertOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Category cate = findById(id);
        if (cate != null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
