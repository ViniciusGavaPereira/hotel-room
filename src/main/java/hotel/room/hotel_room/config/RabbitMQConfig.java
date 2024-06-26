package hotel.room.hotel_room.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

    // Nome da fila
    @Value("${broker.queue.room.name}")
    private String queue;

    // Cria uma fila
    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    // Converte a chamada json em um formato que o java consegue entender
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
