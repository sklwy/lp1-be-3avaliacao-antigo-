package com.project.lp1.utils.factory.order;

import com.project.lp1.enums.OrderType;
import com.project.lp1.utils.strategy.order.OrderDelivery;
import com.project.lp1.utils.strategy.order.OrderLocal;
import com.project.lp1.utils.strategy.order.OrderStrategy;

public class OrderFactory {

    public static OrderStrategy getOrderStrategy(OrderType orderType) {
        switch (orderType) {
            case LOCAL:
                return new OrderLocal();
            case DELIVERY:
                return new OrderDelivery();
            default:
                return null;
        }
    }
}
