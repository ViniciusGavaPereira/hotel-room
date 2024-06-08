package hotel.room.hotel_room.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.room.hotel_room.dto.RoomDto;
import hotel.room.hotel_room.entities.Room;
import hotel.room.hotel_room.entities.RoomStatus;
import hotel.room.hotel_room.services.RoomService;

@Controller
@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/all")
    public List<RoomDto> findALl() {
        List<Room> result = roomService.findAll();
        return RoomDto.roomConverter(result);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<RoomDto>> findByName(@PathVariable String name) {
        List<Room> result = roomService.findByName(name);
        return new ResponseEntity<List<RoomDto>>(RoomDto.roomConverter(result), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RoomDto>> findByStatus(@PathVariable RoomStatus status) {
        List<Room> result = roomService.findByStatus(status);
        return new ResponseEntity<List<RoomDto>>(RoomDto.roomConverter(result), HttpStatus.OK);
    }

    @GetMapping("/roomNumber/{roomNumber}")
    public ResponseEntity<List<RoomDto>> findByStatus(@PathVariable Integer roomNumber) {
        List<Room> result = roomService.findByRoomNumber(roomNumber);
        return new ResponseEntity<List<RoomDto>>(RoomDto.roomConverter(result), HttpStatus.OK);
    }

}
