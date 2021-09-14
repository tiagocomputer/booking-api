package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class DepositPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "deadline")
    private LocalDate deadline;
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acceptedPayments_id", referencedColumnName = "id")
    private PaymentPolicy acceptedPayments;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prepay_id", referencedColumnName = "id")
    private PaymentPolicy prepay;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "holdTime_id", referencedColumnName = "id")
    private HoldPolicy holdTime;
}
