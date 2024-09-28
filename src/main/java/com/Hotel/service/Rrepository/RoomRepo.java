package com.Hotel.service.Rrepository;

import com.Hotel.service.Entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Rooms,Integer> {
}
