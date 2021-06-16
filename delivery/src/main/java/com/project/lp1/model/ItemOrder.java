package com.project.lp1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "MGMT_ITEM_ORDER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID", nullable = false)
    @Id
    private Long itemId;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @JsonIgnore
    @JoinColumn(name = "ORDER_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;

    @Column(name = "QTD_ITEM")
    private Integer qtdItem;

    @Column(name = "SUB_TOTAL_PRICE", precision = 19, scale = 2)
    private Double subTotalPrice;

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.JSON_STYLE, true, true);
    }
}