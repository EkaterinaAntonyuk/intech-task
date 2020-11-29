package com.intech.subscriber.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase extends Message {
    public Purchase() {
        super();
    }

    public Purchase(int id, int msisdn, Date timestamp) {
        super(id, msisdn, timestamp);
    }
}
