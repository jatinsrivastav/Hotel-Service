package com.Hotel.service.Controller;


import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelService")
public class HotelController {


    @Autowired
    HotelService hotelService;


    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllhotels();
    }


    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotels(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.OK);
    }


}
