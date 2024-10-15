package com.Hotel.service.dto;


import com.Hotel.service.Entity.Rooms;
import lombok.Data;

import java.util.List;

@Data
public class HotelDTO {
    private Integer id;
    private String name;
    private String city;
    private List<Rooms> rooms;
}
