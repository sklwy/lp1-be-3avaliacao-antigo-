package com.project.lp1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.lp1.enums.OrderStatus;
import com.project.lp1.enums.OrderType;
import com.project.lp1.utils.strategy.order.OrderStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Table(name = "MGMT_ORDER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false)
    @Id
    private Long orderId;

    @JsonBackReference(value = "command-orders")
    @JoinColumn(name = "COMMAND_ID")
    @ManyToOne
    private Command command;

    @JsonBackReference(value = "dashboardOrder-orders")
    @JoinColumn(name = "DASH_ID")
    @ManyToOne
    private DashboardOrder dashboardOrder;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ItemOrder> items;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    @Column(name = "TOTAL_PRICE", precision = 19, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType;

    public void processOrder(OrderStrategy orderStrategy) {
        double sum = 0.0;
        for (ItemOrder item : items) {
            sum += item.getSubTotalPrice();
        }
        this.setTotalPrice(BigDecimal.valueOf(sum));
        orderStrategy.calculateOrder(this.totalPrice);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.JSON_STYLE, true, true);
    }
}