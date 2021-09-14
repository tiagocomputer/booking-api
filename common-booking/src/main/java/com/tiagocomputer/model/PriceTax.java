package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class PriceTax implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "currency")
    private BigDecimal currency;//Currency code of the tax
    @Column(name = "amount")
    private BigDecimal amount;//Amount of the tax
    @Column(name = "code")
    private String code;//The tax code which identifies the tax. Examples: 1=BED_TAX 2=CITY_TAX
    @Column(name = "percentage")
    private String percentage;//percentage of the tax. Use together with pricingFrequency and pricingMode
    @Column(name = "included")
    private boolean included;//Is the tax included in the base amount
    @Column(name = "description")
    private String description;//Textual description of the tax
    @Column(name = "pricingFrequency")
    private String pricingFrequency;//Specifies if the tax applies per stay or per night. PER_STAY / PER_NIGHT
    @Column(name = "pricingMode")
    private String pricingMode;//Specifies if the tax applies per occupant or per room. PER_OCCUPANT / PER_PRODUCT

}
