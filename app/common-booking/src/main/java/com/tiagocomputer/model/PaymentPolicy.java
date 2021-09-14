package com.tiagocomputer.model;

import com.tiagocomputer.enums.PaymentMethodsEnums;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class PaymentPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    @Column(name = "creditCards")
    private List<String> creditCards;
    @Column(name = "methods")
    private PaymentMethodsEnums methods;

}
