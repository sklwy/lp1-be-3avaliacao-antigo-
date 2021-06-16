package com.project.lp1.controller;

import com.project.lp1.model.Order;
import com.project.lp1.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.insert(order), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Order>> list() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }
}
