package com.project.lp1.service;

import com.project.lp1.model.DashboardOrder;
import com.project.lp1.repository.DashboardOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardOrderService {

    private final DashboardOrderRepository dashboardOrderRepository;

    public DashboardOrderService(DashboardOrderRepository dashboardOrderRepository) {
        this.dashboardOrderRepository = dashboardOrderRepository;
    }

    public List<DashboardOrder> findAll() {
        return dashboardOrderRepository.findAll();
    }
}
