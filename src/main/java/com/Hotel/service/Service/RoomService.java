package com.Hotel.service.Service;

import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Entity.Rooms;
import com.Hotel.service.Rrepository.HotelRepo;
import com.Hotel.service.Rrepository.RoomRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {


    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private HotelRepo hotelRepo;


    public Rooms addRooms(Rooms rooms, Integer id) {
        Hotel hotelDetails = hotelRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
        Rooms roomsEntity = new Rooms();
        roomsEntity.setType(rooms.getType());
        roomsEntity.setPrice(rooms.getPrice());
        roomsEntity.setAvailability(rooms.getAvailability());
        roomsEntity.setHotel(hotelDetails);

        return roomRepo.save(roomsEntity);


    }


    public List<Rooms> getAllRooms() {
        return roomRepo.findAll();
    }

    public void deleteRoom(Integer hotelId, Integer roomId) {
        Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(() -> new EntityNotFoundException("didn't find hotel"));
        Rooms room = roomRepo.findById(roomId).orElseThrow(() -> new EntityNotFoundException("didn't find room"));

        if (!hotel.getId().equals(room.getHotel().getId())) {
            throw new IllegalArgumentException("didn't match hotel with room");
        }

        roomRepo.deleteById(roomId);

    }
}
