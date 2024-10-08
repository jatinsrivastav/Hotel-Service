package com.Hotel.service.Service;

import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Rrepository.HotelRepo;
import com.Hotel.service.Rrepository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private RoomRepo roomRepo;


    public List<Hotel> getAllhotels() {
        return hotelRepo.findAll();
    }


    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public Optional<Hotel> getHotelbyid(Integer id) {
        return hotelRepo.findById(id);
    }

    public Hotel updateHotelbyId(Hotel hotel) {
        Optional<Hotel> h = hotelRepo.findById(hotel.getId());
        if (h.isPresent()) {
            return hotelRepo.save(hotel);
        }

        return null;
    }

    public void deleteHotel(Integer id) {
        Optional<Hotel> h = hotelRepo.findById(id);
        if (h.isPresent()) {
            hotelRepo.deleteById(id);

        }

    }
}
