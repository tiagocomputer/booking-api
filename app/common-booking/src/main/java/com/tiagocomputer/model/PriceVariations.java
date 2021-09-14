package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class PriceVariations implements Serializable {

    private static final long serialVersionUID = 1L;

    //Daily price variations and the average daily price (when available) is shown here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "average_id", referencedColumnName = "id")
    private BaseTotalAmount average;
}
