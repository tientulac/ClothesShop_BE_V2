package com.example.backend.services.discount;
import com.example.backend.entities.Discount;

import java.util.List;

public interface DiscountService {
    List<Discount> findAll();
    Discount updateOne(Discount discount);
    Discount insertOne(Discount discount);
    Discount findById(int id);
    boolean deleteOne(int id);
}
