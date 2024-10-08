package com.Hotel.service.Controller;


import com.Hotel.service.Entity.Hotel;
import com.Hotel.service.Entity.Rooms;
import com.Hotel.service.Service.HotelService;
import com.Hotel.service.Service.RoomService;
import com.Hotel.service.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Hotel> getAllHotels() {
        return hotelService.getAllhotels();
    }

    @GetMapping("/hotels/{id}")
    public Optional<Hotel> gethotelbyId(@PathVariable Integer id) {
        return hotelService.getHotelbyid(id);
    }


    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotels(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.OK);
    }

    @PutMapping("/hotel")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotelbyId(hotel), HttpStatus.OK);
    }


   /* @DeleteMapping("hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Integer id){
        return  new ResponseEntity<>(hotelService.deleteHotel(id), HttpStatus.OK);
    }*/


    @DeleteMapping("hotel/{id}")
    public void deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
    }


    @PostMapping("/hotel/addRoom/{id}")
    public ResponseEntity<Rooms> addRooms(@RequestBody Rooms rooms, @PathVariable Integer id ){
        return new ResponseEntity<>(roomService.addRooms(rooms, id), HttpStatus.OK);
    }


    @GetMapping("/rooms")
    public  ResponseEntity<List<Rooms>>getAllrooms (){
        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }


    @DeleteMapping("/hotels/{hotelId}/rooms/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer hotelId, @PathVariable Integer roomId){
          roomService.deleteRoom(hotelId, roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
