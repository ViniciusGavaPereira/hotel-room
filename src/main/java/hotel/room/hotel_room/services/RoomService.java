package hotel.room.hotel_room.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Room> findByName(String name) {
        return roomRepository.findByNameContaining(name);
    }

    public List<Room> findByStatus(RoomStatus status) {
        return roomRepository.findByRoomStatus(status);
    }

    public List<Room> findByRoomNumber(Integer roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

}
