package com.example.backend.controller;

import com.example.backend.dtos.OrderDTO;
import com.example.backend.entities.Account;
import com.example.backend.entities.Order;
import com.example.backend.services.account.AccountService;
import com.example.backend.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/order") // router
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderDTO> getList() {
        try {
            List<Order> list = orderService.findAll();

            var listDTO = new ArrayList<OrderDTO>();
            for (Order o : list) {
                Account acc = accountService.findById(o.getAccount_id());
                OrderDTO oDTO = new OrderDTO();
                oDTO.setOrder_id(o.getOrder_id());
                oDTO.setAccount_id(o.getAccount_id());
                oDTO.setStatus(o.getStatus());
                oDTO.setAddress_from(o.getAddress_from());
                oDTO.setAddress_to(o.getAddress_to());
                oDTO.setType_payment(o.getType_payment());
                oDTO.setTime_delivery(o.getTime_delivery());
                oDTO.setCart_id(o.getCart_id());
                oDTO.setUser_name(acc.getUser_name());
                System.out.println(o.getAccount_id());
                listDTO.add(oDTO);
            }
            return listDTO;
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
            if (orderService.deleteOne(id)) {
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
