package hotel.room.hotel_room.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import hotel.room.hotel_room.dtos.RoomDto;
import hotel.room.hotel_room.services.RoomService;

@Component
public class RoomConsumeer {

    @Autowired
    private RoomService roomService;

    @RabbitListener(queues = "${broker.queue.room.name}")
    public void listenRoomQueue(@Payload RoomDto roomDto) {
        roomService.createRoom(roomDto);

    }
}
