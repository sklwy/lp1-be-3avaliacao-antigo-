package com.project.lp1.service;

import com.project.lp1.exception.BadRequestException;
import com.project.lp1.model.ItemOrder;
import com.project.lp1.model.Order;
import com.project.lp1.repository.OrderRepository;
import com.project.lp1.utils.factory.order.OrderFactory;
import com.project.lp1.utils.strategy.order.OrderStrategy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemOrderService itemOrderService;

    public OrderService(OrderRepository orderRepository, ItemOrderService itemOrderService) {
        this.orderRepository = orderRepository;
        this.itemOrderService = itemOrderService;
    }

    public Order insert(@Validated Order order) {
        ItemOrder item = new ItemOrder();
        OrderStrategy orderStrategy = OrderFactory.getOrderStrategy(order.getOrderType());
        order.processOrder(orderStrategy);
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long orderId) {
        return Optional.ofNullable(orderRepository.findById(orderId)
                .orElseThrow(() -> new BadRequestException("Order Not Found!")));
    }
}


