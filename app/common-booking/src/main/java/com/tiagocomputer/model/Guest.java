package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ElementCollection
    @Column(name = "adults")
    private List<Integer> adults;
    @ElementCollection
    @Column(name = "child_ages")
    private List<Integer> childAges;
}
