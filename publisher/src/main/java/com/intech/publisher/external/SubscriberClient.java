package com.intech.publisher.external;

import com.intech.model.dto.MessageDto;
import com.intech.publisher.service.Starter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class SubscriberClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);
    private final RestTemplate restTemplate;

    public SubscriberClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendMessage(MessageDto message) {
        HttpEntity<MessageDto> request = new HttpEntity<>(message);
        restTemplate.postForObject("http://localhost:8080/subscriber", request, Void.class);
        LOGGER.info("Sent {} message, id = {}", message.getAction(), message.getId());
    }

    public int getLastId() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/subscriber/last-id";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        LOGGER.info("get last id");
        return Integer.parseInt(Objects.requireNonNull(response.getBody()));
    }
}
