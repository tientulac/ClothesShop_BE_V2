package com.example.backend.services.order;
import com.example.backend.entities.Order;
import com.example.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Order order = findById(id);
        if (order != null) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
