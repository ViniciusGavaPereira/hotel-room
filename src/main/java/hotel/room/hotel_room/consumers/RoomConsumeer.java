package hotel.room.hotel_room.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import hotel.room.hotel_room.dtos.RoomDto;

@Component
public class RoomConsumeer {

    @RabbitListener(queues = "${broker.queue.room.name}")
    public void listenRoomQueue(@Payload RoomDto roomDto) {
        System.out.println(roomDto.toString());
    }
}
