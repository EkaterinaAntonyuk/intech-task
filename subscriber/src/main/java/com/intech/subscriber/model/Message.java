package com.intech.subscriber.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
public abstract class Message {
    @Id
    private int id;
    private int msisdn;
    private Date timestamp;

    public Message() {
    }

    public Message(int id, int msisdn, Date timestamp) {
        this.id = id;
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }
}
