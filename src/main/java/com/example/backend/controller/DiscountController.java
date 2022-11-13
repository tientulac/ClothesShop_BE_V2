package com.example.backend.controller;

import com.example.backend.entities.Category;
import com.example.backend.entities.Discount;
import com.example.backend.services.discount.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/discount") // router
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Discount> getList() {
        try {
            List<Discount> list = discountService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Discount save(@RequestBody Discount discount) {
        try {
            if (discount.getDiscount_id() > 0) {
                discount.setUpdate_at(new Date());
                discount = discountService.updateOne(discount);
            }
            else {
                discount.setCreated_at(new Date());
                discount = discountService.insertOne(discount);
            }
            return discount;
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
            if (discountService.deleteOne(id)) {
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
