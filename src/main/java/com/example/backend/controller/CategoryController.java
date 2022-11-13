package com.example.backend.controller;

import com.example.backend.entities.Category;
import com.example.backend.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/category") // router
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getList() {
        try {
            List<Category> list = categoryService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category save(@RequestBody Category category) {
        try {
            if (category.getCategory_id() > 0) {
                category.setUpdate_at(new Date());
                category = categoryService.updateOne(category);
            }
            else {
                System.out.println(category.getCategory_name());
                category.setCreated_at(new Date());
                category = categoryService.insertOne(category);
            }
            return category;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (categoryService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
