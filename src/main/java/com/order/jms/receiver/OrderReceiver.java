package com.order.jms.receiver;

import com.order.jms.domain.Order;
import com.order.jms.domain.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "order-queue")
    public void receiver(Order order){
        System.out.println("Order received: ");
        System.out.println(order.getId());
        System.out.println(order.getOrderDate());
        double sum = 0.0;
        for(Product product : order.getProducts()){
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
            sum += product.getPrice();
        }
        System.out.println("Total order price: " + sum);
    }
}
