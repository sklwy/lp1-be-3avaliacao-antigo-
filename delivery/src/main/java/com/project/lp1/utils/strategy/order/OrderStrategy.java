package com.project.lp1.utils.strategy.order;

import com.project.lp1.model.Order;

import java.math.BigDecimal;

public interface OrderStrategy {
    void calculateOrder(BigDecimal value);
}
