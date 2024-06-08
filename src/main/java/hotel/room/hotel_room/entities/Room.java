package hotel.room.hotel_room.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "RoomStatus")
    private RoomStatus roomStatus;

    public Room() {
    }

    public Room(Integer id, Integer roomNumber, String name, Float price, RoomStatus roomStatus) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.name = name;
        this.pricePerHour = price;
        this.roomStatus = roomStatus;
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

    public Float getPrice() {
        return pricePerHour;
    }

    public void setPrice(Float price) {
        this.pricePerHour = price;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

}
