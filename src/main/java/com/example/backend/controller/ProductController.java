package com.example.backend.controller;
import com.example.backend.dtos.ProductDTO;
import com.example.backend.dtos.ProductFilterDTO;
import com.example.backend.entities.*;
import com.example.backend.services.brand.BrandService;
import com.example.backend.services.category.CategoryService;
import com.example.backend.services.product.ProductColorService;
import com.example.backend.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    ProductColorService productColorService;

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

    @RequestMapping(method = RequestMethod.POST, path = "/filter")
    public List<ProductDTO> filterProduct(@RequestBody ProductFilterDTO prodFilter) {
        try {
            System.out.println(prodFilter.getCategory_id());
            List<ProductColor> listProductColor = productColorService.findAll();

            var listDTO  = getList().stream().filter(x -> x.getCategory_id() == prodFilter.getCategory_id()).collect(Collectors.toList());

//            if (prodFilter.getList_color().size() > 0) {
//                var listColorFilter = listProductColor.stream().filter(c -> prodFilter.getList_color().contains(c.getColor())).collect(Collectors.toList());
//                var listIdProductColor = listColorFilter.stream().map(c -> c.getProduct_id()).collect(Collectors.toList());
//                listDTO = listDTO.stream().filter(p -> listIdProductColor.contains(p.getProduct_id())).collect(Collectors.toList());
//            }
//            if (prodFilter.getList_size().size() > 0) {
//                for (ProductDTO pDTO : listDTO) {
//                    pDTO.setList_size(Arrays.stream(pDTO.getSize().split(",", 0)).collect(Collectors.toList()));
//                }
//                for (ProductDTO pDTO : listDTO) {
//                    for (var size: pDTO.getList_size()) {
//                        if (!prodFilter.getList_size().contains(size)) {
//                            listDTO = listDTO.stream().filter(o -> o.getProduct_id() != pDTO.getProduct_id()).collect(Collectors.toList());
//                        }
//                    }
//                }
//            }
            return listDTO;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
