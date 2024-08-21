package hotel.room.hotel_room.entities;

import hotel.room.hotel_room.dtos.RoomDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "RoomNumber", unique = true)
    private Integer roomNumber;

    @Column(name = "Name")
    private String name;

    @Column(name = "Price_per_hour")
    private Float pricePerHour;

    public Room() {
    }

    public Room(Integer id, Integer roomNumber, String name, Float price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.name = name;
        this.pricePerHour = price;

    }

    public Room(RoomDto roomDto) {
        this.id = null;
        this.roomNumber = roomDto.getRoomNumber();
        this.name = roomDto.getName();
        this.pricePerHour = roomDto.getPricePerHour();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", roomNumber=" + roomNumber + ", name=" + name + ", pricePerHour=" + pricePerHour
                + "]";
    }

}
