package hotel.room.hotel_room.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import exception.CustomApplicationException;
import hotel.room.hotel_room.dtos.RoomDto;
import hotel.room.hotel_room.entities.Room;
import hotel.room.hotel_room.entities.RoomStatus;
import hotel.room.hotel_room.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(Integer id) {
        Room result = roomRepository.findById(id)
                .orElseThrow(() -> new CustomApplicationException("Room with ID: " + id + " not found",
                        HttpStatus.NOT_FOUND));
        return result;
    }

    public List<Room> findByName(String name) {
        return roomRepository.findByNameContaining(name);
    }

    public List<Room> findByStatus(RoomStatus status) {
        return roomRepository.findByRoomStatus(status);
    }

    public Room findByRoomNumber(Integer roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public Room createRoom(RoomDto roomInput) {
        Room room = new Room(roomInput);
        System.out.println("Service roomInput: " + roomInput.toString());

        System.out.println("Service room: " + room.toString());
        return roomRepository.save(room);
    }

    public Room deleteByRoomNumber(Integer roomNumberInput) {
        Room room = roomRepository.findByRoomNumber(roomNumberInput);
        roomRepository.delete(room);
        return room;
    }

    public Room updateRoom(Room roomInput) {
        Room room = roomRepository.findByRoomNumber(roomInput.getRoomNumber());

        room.setRoomNumber(roomInput.getRoomNumber());
        room.setName(roomInput.getName());
        room.setPricePerHour(roomInput.getPricePerHour());
        room.setRoomStatus(roomInput.getRoomStatus());

        roomRepository.save(room);

        return room;
    }

    public Room updateRoomStatus(Integer id, RoomStatus roomStatus) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomStatus(roomStatus);
        return roomRepository.save(room);
    }

}
