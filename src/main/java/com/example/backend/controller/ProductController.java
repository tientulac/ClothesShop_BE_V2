package com.example.backend.controller;
import com.example.backend.dtos.ProductDTO;
import com.example.backend.entities.*;
import com.example.backend.services.brand.BrandService;
import com.example.backend.services.category.CategoryService;
import com.example.backend.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/product") // router
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> getList() {
        try {
            List<Product> list = productService.findAll();
            var listDTO = new ArrayList<ProductDTO>();

            for (Product p : list) {
                Category cate = categoryService.findById(p.getCategory_id());
                Brand brand = brandService.findById(p.getBrand_id());
                ProductDTO pDTO = new ProductDTO();
                pDTO.setProduct_id(p.getProduct_id());
                pDTO.setAmount(p.getAmount());
                pDTO.setBrand_id(p.getBrand_id());
                pDTO.setCategory_id(p.getCategory_id());
                pDTO.setCreated_at(p.getCreated_at());
                pDTO.setDeleted_at(p.getDeleted_at());
                pDTO.setGender(p.getGender());
                pDTO.setOrigin(p.getOrigin());
                pDTO.setPrice(p.getPrice());
                pDTO.setProduct_name(p.getProduct_name());
                pDTO.setStatus(p.getStatus());
                pDTO.setUpdate_at(p.getUpdate_at());
                pDTO.setCategory_name(cate.getCategory_name());
                pDTO.setBrand_name(brand.getBrand_name());
                pDTO.setSize(p.getSize());
                listDTO.add(pDTO);
            }
            return listDTO;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product prod) {
        try {
            if (prod.getProduct_id() > 0) {
                prod.setUpdate_at(new Date());
                prod = productService.updateOne(prod);
            }
            else {
                prod.setCreated_at(new Date());
                prod = productService.insertOne(prod);
            }
            return prod;
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
            if (productService.deleteOne(id)) {
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
