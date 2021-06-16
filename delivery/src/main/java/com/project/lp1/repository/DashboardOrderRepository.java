package com.project.lp1.repository;

import com.project.lp1.model.DashboardOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardOrderRepository extends JpaRepository<DashboardOrder, Long> {
}