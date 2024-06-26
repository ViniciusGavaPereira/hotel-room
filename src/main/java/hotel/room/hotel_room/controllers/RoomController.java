package hotel.room.hotel_room.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.CustomApplicationException;
import hotel.room.hotel_room.dtos.RoomDto;
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
    public ResponseEntity<RoomDto> findByRoomNumber(@PathVariable Integer roomNumber) {
        Room result = roomService.findByRoomNumber(roomNumber);
        return new ResponseEntity<RoomDto>(new RoomDto(result), HttpStatus.OK);
    }

    @PostMapping("/create/v1/")
    public ResponseEntity<?> createRoom(@RequestBody Room roomInput) {
        roomService.createRoom(roomInput);

        return new ResponseEntity<>(new RoomDto(roomInput).toString(), HttpStatus.CREATED);
    }

    @PutMapping("/update/")
    public ResponseEntity<RoomDto> updateClient(@RequestBody Room roomInput) {

        try {
            Room result = roomService.updateRoom(roomInput);
            return new ResponseEntity<RoomDto>(new RoomDto(result), HttpStatus.OK);

        } catch (EmptyResultDataAccessException e) {
            throw new CustomApplicationException("Room not found", HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Integer id) {
        roomService.deleteByRoomNumber(id);
        return new ResponseEntity<>("Room was deleted", HttpStatus.ACCEPTED);
    }

}
