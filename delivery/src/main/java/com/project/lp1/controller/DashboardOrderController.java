package com.project.lp1.controller;

import com.project.lp1.model.DashboardOrder;
import com.project.lp1.service.DashboardOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/dashboardOrder")
@RestController
public class DashboardOrderController {

    private final DashboardOrderService dashboardOrderService;

    public DashboardOrderController(DashboardOrderService dashboardOrderService) {
        this.dashboardOrderService = dashboardOrderService;
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<DashboardOrder>> list() {
        return ResponseEntity.ok(dashboardOrderService.findAll());
    }
}
