package com.intech.subscriber.service;

import com.intech.model.dto.Action;
import com.intech.model.dto.MessageDto;
import com.intech.subscriber.model.Purchase;
import com.intech.subscriber.model.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.intech.subscriber.repository.MessageRepository;

import java.sql.Date;

@Service
public class SubscriberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriberService.class);
    private MessageRepository messageRepository;

    public SubscriberService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void createMessage(MessageDto messageDto) {
        if (messageDto.getAction().equals(Action.PURCHASE)) {
            Purchase purchase = new Purchase(messageDto.getId(),
                    messageDto.getMsisdn(), Date.from(messageDto.getTimestamp()));
            messageRepository.addMessage(purchase);
            LOGGER.info("Created purchase message, id = {}", messageDto.getId());
        } else if (messageDto.getAction().equals(Action.SUBSCRIPTION)) {
            Subscription subscription = new Subscription(messageDto.getId(),
                    messageDto.getMsisdn(), Date.from(messageDto.getTimestamp()));
            messageRepository.addMessage(subscription);
            LOGGER.info("Created subscription message, id = {}", messageDto.getId());
        }
    }

    public int getLastId() {
        return Math.max(messageRepository.getLastId(Purchase.class), messageRepository.getLastId(Subscription.class));
    }
}
