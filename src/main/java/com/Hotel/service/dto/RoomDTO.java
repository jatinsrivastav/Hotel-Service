package com.Hotel.service.dto;

import com.Hotel.service.Entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Integer id;
    private String type;
    private Integer price;
    private Boolean availability;
    private Hotel hotel;
}
