package com.tiagocomputer.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class RoomDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "category")
    private String category;
    @Column(name = "beds")
    private Integer beds;
    @Column(name = "bedType")
    private String bedType;
    @Column(name = "freeRoom")
    private Integer freeRoom;
    @Column(name = "available_room")
    private Boolean availableRoom = false;
}
