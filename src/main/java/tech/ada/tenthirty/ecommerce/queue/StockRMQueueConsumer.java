package tech.ada.tenthirty.ecommerce.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import tech.ada.tenthirty.ecommerce.payload.ReservaRequest;
import tech.ada.tenthirty.ecommerce.service.ReservarItensService;

@Component
@RequiredArgsConstructor
public class StockRMQueueConsumer {
    private final ObjectMapper objectMapper;
    private final ReservarItensService reservarItensService;

    @RabbitListener(queues = {"${spring.config.fila.reservation.in}"})
    public void receive(@Payload String fileBody) throws JsonProcessingException {
        ReservaRequest reservaRequest = objectMapper.readValue(fileBody, ReservaRequest.class);
        reservarItensService.execute(reservaRequest);
    }
}
