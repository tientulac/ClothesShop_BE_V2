package com.example.backend.services.discount;

import com.example.backend.entities.Category;
import com.example.backend.entities.Discount;
import com.example.backend.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImp implements DiscountService{
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount updateOne(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount insertOne(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount findById(int id) {
        return discountRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Discount disc = findById(id);
        if (disc != null) {
            discountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
