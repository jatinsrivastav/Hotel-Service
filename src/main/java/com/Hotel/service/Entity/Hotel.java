package com.Hotel.service.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;

    // if you put persist then it will not delete the old data while adding the rooms.
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Rooms> rooms;

    public void addRoom(Rooms room) {
        this.rooms.add(room);
        room.setHotel(this);
    }

}
