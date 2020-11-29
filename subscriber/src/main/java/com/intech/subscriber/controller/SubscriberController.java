package com.intech.subscriber.controller;

import com.intech.model.dto.MessageDto;
import com.intech.subscriber.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {
    private SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/last-id")
    public int getLastId() {
        return subscriberService.getLastId();
    }

    @PostMapping
    public ResponseEntity<Void> createMessage(@RequestBody MessageDto message) {
        subscriberService.createMessage(message);
        return ResponseEntity.noContent().build();
    }
}
