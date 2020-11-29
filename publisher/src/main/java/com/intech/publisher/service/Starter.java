package com.intech.publisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.intech.publisher.external.SubscriberClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Starter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Starter.class);

    private final PublisherService publisherService;
    private final ExecutorService executorService;
    private final SubscriberClient subscriberClient;
    private AtomicInteger atomicInt;

    public Starter(PublisherService publisherService, ExecutorService executorService, SubscriberClient subscriberClient) {
        this.publisherService = publisherService;
        this.executorService = executorService;
        this.subscriberClient = subscriberClient;
    }

    @PostConstruct
    public void start() {
        atomicInt = new AtomicInteger(subscriberClient.getLastId());
        Runnable task = () -> {
            while (!Thread.interrupted()) {
                publisherService.sendMessage(atomicInt.incrementAndGet());
                try {
                    Thread.sleep(15 * 1000);
                } catch (InterruptedException e) {
                    LOGGER.warn("interrupted");
                }
            }
        };
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }
    }

    @PreDestroy
    public void stop() {
        LOGGER.info("shutdown");
        executorService.shutdownNow();
    }


}
