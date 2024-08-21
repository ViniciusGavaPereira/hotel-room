package hotel.room.hotel_room.dtos;

import java.util.stream.Collectors;
import java.util.List;

import hotel.room.hotel_room.entities.Room;

public class RoomDto {

    private Integer id;
    private Integer roomNumber;
    private String name;
    private Float pricePerHour;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        id = room.getId();
        roomNumber = room.getRoomNumber();
        name = room.getName();
        pricePerHour = room.getPricePerHour();

    }

    public RoomDto(Integer roomNumber, String name, Float pricePerHour, String roomStatus) {

        this.roomNumber = roomNumber;
        this.name = name;
        this.pricePerHour = pricePerHour;
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
        return "RoomDto [roomNumber=" + roomNumber + ", name=" + name + ", pricePerHour=" + pricePerHour + "]";
    }

    public static List<RoomDto> roomConverter(List<Room> room) {
        return room.stream().map(RoomDto::new).collect(Collectors.toList());
    }

}
