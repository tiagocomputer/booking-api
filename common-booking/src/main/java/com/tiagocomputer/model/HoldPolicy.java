package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class HoldPolicy implements Serializable {

    private static final long serialVersionUID = 1L;

    //description: the hold policy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "deadline")
    private LocalDate deadline;
}
