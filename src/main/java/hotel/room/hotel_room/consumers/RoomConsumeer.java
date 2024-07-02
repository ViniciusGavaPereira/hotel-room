package hotel.room.hotel_room.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hotel.room.hotel_room.dtos.RoomDto;
import hotel.room.hotel_room.services.RoomService;

@Component
public class RoomConsumeer {

    @Autowired
    private RoomService roomService;

    @RabbitListener(queues = "${broker.queue.room.name}")
    public void listenRoomQueue(@Payload String room) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(room);

            Integer roomNumber = jsonNode.get("roomNumber").asInt();
            String name = jsonNode.get("name").asText();
            Float pricePerHour = (float) jsonNode.get("pricePerHour").asDouble();
            String roomStatus = jsonNode.get("roomStatus").asText();

            RoomDto roomDto = new RoomDto(roomNumber, name, pricePerHour, roomStatus);
            roomService.createRoom(roomDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
