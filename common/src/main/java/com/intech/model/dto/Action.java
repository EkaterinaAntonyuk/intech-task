package com.intech.model.dto;

import java.util.List;
import java.util.Random;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    private static final Random RANDOM = new Random();

    private static final List<Action> VALUES = List.of(values());

    public static Action getRandom() {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
