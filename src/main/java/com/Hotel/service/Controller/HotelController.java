package com.Hotel.service.Controller;


import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Entity.Rooms;
import com.Hotel.service.Service.HotelService;
import com.Hotel.service.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotelService")
public class HotelController {


    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;


    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel> >getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllhotels(), HttpStatus.OK);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Optional<Hotel>> gethotelbyId(@PathVariable Integer id) {
        return new ResponseEntity<>(hotelService.getHotelbyid(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotels(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.OK);
    }

    @PutMapping("/hotel")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotelbyId(hotel), HttpStatus.OK);
    }



    @DeleteMapping("hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/hotel/addRoom/{id}")
    public ResponseEntity<Rooms> addRooms(@RequestBody Rooms rooms, @PathVariable Integer id) {
        return new ResponseEntity<>(roomService.addRooms(rooms, id), HttpStatus.OK);
    }


    @GetMapping("/rooms")
    public ResponseEntity<List<Rooms>> getAllrooms() {
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }


    @DeleteMapping("/hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer hotelId, @PathVariable Integer roomId) {
        roomService.deleteRoom(hotelId, roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Rooms> getRoombyHotelId(@PathVariable Integer hotelId, @PathVariable Integer roomId) {
        return new ResponseEntity<>(roomService.getroombyHotelId(hotelId, roomId), HttpStatus.OK);

    }

    @GetMapping("/hotels/rooms/{hotelId}/{roomId}")
    public ResponseEntity<Hotel> HotelbyId(@PathVariable Integer hotelId, @PathVariable Integer roomId) {
        return new ResponseEntity<>(roomService.getHotelRoomDetails(hotelId, roomId), HttpStatus.OK);

    }


}
