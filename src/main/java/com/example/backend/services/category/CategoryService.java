package com.example.backend.services.category;

import com.example.backend.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category updateOne(Category category);
    Category insertOne(Category category);
    Category findById(int id);
    boolean deleteOne(int id);
}
