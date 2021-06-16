package com.project.lp1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Set;

@Table(name = "MGMT_DASHBOARD_ORDER")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardOrder {

    @Column(name = "DASH_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dashId;

    @JsonManagedReference(value = "dashboardOrder-orders")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dashboardOrder", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Order> orders;

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.JSON_STYLE, true, true);
    }
}
