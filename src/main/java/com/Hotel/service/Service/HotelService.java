package com.Hotel.service.Service;

import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Rrepository.HotelRepo;
import com.Hotel.service.Rrepository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private RoomRepo roomRepo;


    public List<Hotel> getAllhotels() {
        return hotelRepo.findAll();
    }


    public Hotel createHotel(Hotel hotel){
        return hotelRepo.save(hotel);
    }

}
