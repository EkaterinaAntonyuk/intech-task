package com.intech.subscriber.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "subscription")
public class Subscription extends Message {
    public Subscription() {
        super();
    }

    public Subscription(int id, int msisdn, Date timestamp) {
        super(id, msisdn, timestamp);
    }
}

