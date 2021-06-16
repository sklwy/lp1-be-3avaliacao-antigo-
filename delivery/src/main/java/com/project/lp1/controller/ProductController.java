package com.project.lp1.controller;

import com.project.lp1.model.Product;
import com.project.lp1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/product")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product product) {
        return new ResponseEntity<>(productService.insert(product), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }
}
