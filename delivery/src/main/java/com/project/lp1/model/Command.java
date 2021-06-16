package com.project.lp1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.lp1.enums.CommandStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "MGMT_COMMAND")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    @Column(name = "COMMAND_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandId;

    @Column(name = "INI_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iniDate;

    @Column(name = "FINAL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "COMMAND_STATUS")
    private CommandStatus commandStatus;

    @JsonManagedReference(value = "command-orders")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "command", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Order> orders;

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.JSON_STYLE, true, true);
    }
}