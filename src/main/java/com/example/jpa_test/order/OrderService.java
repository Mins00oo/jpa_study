package com.example.jpa_test.order;

import com.example.jpa_test.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrder() {
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            order.getOrderDetails().forEach(orderDetail -> {
                Product product = orderDetail.getProduct();
            });
        }

        return orders;
    }
}
