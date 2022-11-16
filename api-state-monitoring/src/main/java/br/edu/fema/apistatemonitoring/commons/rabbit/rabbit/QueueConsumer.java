package br.edu.fema.apistatemonitoring.commons.rabbit.rabbit;

import br.edu.fema.apistatemonitoring.client.model.Client;
import br.edu.fema.apistatemonitoring.client.service.ClientService;
import br.edu.fema.apistatemonitoring.requests.model.HttpRequest;
import br.edu.fema.apistatemonitoring.requests.model.HttpRequestMessage;
import br.edu.fema.apistatemonitoring.requests.model.RabbitMessage;
import br.edu.fema.apistatemonitoring.requests.repository.HttpRequestRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class QueueConsumer {

    private final ClientService clientService;
    private final HttpRequestRepository httpRequestRepository;
    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            RabbitMessage rabbitMessage = mapper.readValue(fileBody, RabbitMessage.class);
            Client client = this.clientService
                    .defineCliente(
                            rabbitMessage.getClientMessage().getClientId(),
                            rabbitMessage.getClientMessage().getClientDescrption(),
                            rabbitMessage.getClientMessage().getClientAddress(),
                            rabbitMessage.getClientMessage().getClientPort());
            HttpRequest request = new HttpRequest(
                    rabbitMessage.getHttpRequestMessage().getStatus(),
                    rabbitMessage.getHttpRequestMessage().getBody(),
                    rabbitMessage.getHttpRequestMessage().getMethod(),
                    rabbitMessage.getHttpRequestMessage().getSender(),
                    rabbitMessage.getHttpRequestMessage().getRequestedUrl(),
                    rabbitMessage.getHttpRequestMessage().getMessage(),
                    LocalDateTime.parse(rabbitMessage.getHttpRequestMessage().getRequestDateTime())
            );
            request.setClient(client);
            this.httpRequestRepository.save(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}