package com.example.backend.controller;

import com.example.backend.entities.Brand;
import com.example.backend.services.brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/brand") // router
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> getList() {
        try {
            List<Brand> list = brandService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Brand save(@RequestBody Brand brand) {
        try {
            if (brand.getBrand_id() > 0) {
                brand.setUpdate_at(new Date());
                brand = brandService.updateOne(brand);
            }
            else {
                brand.setCreated_at(new Date());
                brand = brandService.insertOne(brand);
            }
            return brand;
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
            if (brandService.deleteOne(id)) {
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
