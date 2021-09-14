package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class BaseTotalAmount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //description: estimated nightly average for the stay
    @Column(name = "base")
    private BigDecimal base;//Amount excluding taxes.
    @Column(name = "total")
    private BigDecimal total;//Amount including taxes.

}
