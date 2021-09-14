package com.tiagocomputer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;
    @Column(name = "booking_day")
    private LocalDate bookingDay;
    @Column(name = "booking_start")
    private LocalDate bookingStart;
    @Column(name = "booking_end")
    private LocalDate bookingEnd;
    @Column(name = "cancellation")
    private Boolean cancellation = false;
}
