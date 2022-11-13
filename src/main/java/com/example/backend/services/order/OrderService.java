package com.example.backend.services.order;

import com.example.backend.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    boolean deleteOne(int id);
    Order findById(int id);
}
