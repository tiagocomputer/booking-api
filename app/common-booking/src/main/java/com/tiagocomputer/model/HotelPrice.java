package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class HotelPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "currency")
    private String currency; //Currency code
    @Column(name = "total")
    private BigDecimal total; //Total amount including taxes
    @Column(name = "base")
    private BigDecimal base; //Total amount excluding taxes
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taxes_id", referencedColumnName = "id")
    private PriceTax taxes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variations_id", referencedColumnName = "id")
    private PriceVariations variations;

}
