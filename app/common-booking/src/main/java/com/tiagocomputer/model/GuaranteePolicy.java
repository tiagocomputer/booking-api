package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class GuaranteePolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    //description: the guarantee policy information applicable to the offer. It includes accepted payments
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acceptedPayments_id", referencedColumnName = "id")
    private PaymentPolicy acceptedPayments;
}
