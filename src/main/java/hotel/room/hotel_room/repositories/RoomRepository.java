package hotel.room.hotel_room.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.room.hotel_room.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByNameContaining(String name);


    Room findByRoomNumber(Integer roomNumber);

}
