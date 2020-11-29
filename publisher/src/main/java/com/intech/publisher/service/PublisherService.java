package com.intech.publisher.service;

import com.intech.model.dto.Action;
import com.intech.model.dto.MessageDto;
import org.springframework.stereotype.Service;
import com.intech.publisher.external.SubscriberClient;

import java.util.Date;

@Service
public class PublisherService {
    private final SubscriberClient subscriberClient;

    public PublisherService(SubscriberClient subscriberClient) {
        this.subscriberClient = subscriberClient;
    }

    public void sendMessage(int id) {
        subscriberClient.sendMessage(createMessage(id));
    }

    private MessageDto createMessage(int id) {
        return new MessageDto(id, getRandomNumber(100000000, 999999999), Action.getRandom(), new Date().toInstant());
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
