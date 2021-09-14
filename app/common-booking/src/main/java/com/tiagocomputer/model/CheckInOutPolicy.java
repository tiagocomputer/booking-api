package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class CheckInOutPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "checkIn")
    private LocalDate checkIn;
    @Column(name = "check_In_description")
    private String checkInDescription;
    @Column(name = "checkOut")
    private LocalDate checkOut;
    @Column(name = "check_out_description")
    private String  checkOutDescription;
}
