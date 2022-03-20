package com.order.jms.controller;

import com.order.jms.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping("add")
    public void addOrder(@RequestBody Order order){
        jmsTemplate.convertAndSend("order-queue", order);
    }
}
