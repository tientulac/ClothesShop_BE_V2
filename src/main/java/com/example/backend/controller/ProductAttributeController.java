package com.example.backend.controller;

import com.example.backend.entities.Brand;
import com.example.backend.entities.ProductColor;
import com.example.backend.entities.ProductDetail;
import com.example.backend.entities.ProductImage;
import com.example.backend.services.product.ProductColorService;
import com.example.backend.services.product.ProductDetailService;
import com.example.backend.services.product.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/product/attribute") // router
public class ProductAttributeController {

    @Autowired
    ProductImageService productImageService;

    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ProductColorService productColorService;

    @RequestMapping(method = RequestMethod.GET, path = "/color")
    public List<ProductColor> getListColor() {
        try {
            List<ProductColor> list = productColorService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    public List<ProductDetail> getListDetail() {
        try {
            List<ProductDetail> list = productDetailService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/image")
    public List<ProductImage> getListImage() {
        try {
            List<ProductImage> list = productImageService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/color")
    public ProductColor insertColor(@RequestBody ProductColor prod) {
        try {
            prod = productColorService.insertOne(prod);
            return prod;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/detail")
    public ProductDetail insertDetail(@RequestBody ProductDetail prod) {
        try {
            prod = productDetailService.insertOne(prod);
            return prod;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/image")
    public ProductImage insertImage(@RequestBody ProductImage prod) {
        try {
            prod = productImageService.insertOne(prod);
            return prod;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/color/{id}")
    public boolean deleteColor(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (productColorService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/detail/{id}")
    public boolean deleteDetail(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (productDetailService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/image/{id}")
    public boolean deleteImage(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (productImageService.deleteOne(id)) {
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
