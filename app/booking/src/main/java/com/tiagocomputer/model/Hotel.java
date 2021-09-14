package com.tiagocomputer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private RoomDetails room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_hotel_id", referencedColumnName = "id")
    private AddressHotel addressHotel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_price_id", referencedColumnName = "id")
    private HotelPrice hotelPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_hotel_id", referencedColumnName = "id")
    private ContactHotel contactHotel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

}
