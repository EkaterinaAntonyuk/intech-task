package com.intech.model.dto;

import java.time.Instant;

public class MessageDto {
    private int id;
    private int msisdn;
    private Action action;
    private Instant timestamp;

    public MessageDto(int id, int msisdn, Action action, Instant timestamp) {
        this.id = id;
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public Action getAction() {
        return action;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
