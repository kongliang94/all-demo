package com.example.demo.EnumTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname PizzaStatus
 * @Description TODO
 * @Date 2020/5/30 19:32
 * @Created by windows
 */
public enum PizzaStatus {
    ORDERED(5),
    READY(2),
    DELIVERED(0);

    private int timeToDelivery;

    PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }

    public int getTimeToDelivery() {
        return timeToDelivery;
    }

    private static Map<Integer, PizzaStatus> timeToDeliveryToEnumValuesMapping = new HashMap<>();

    static {
        PizzaStatus[] pizzaStatuses = PizzaStatus.values();
        for (int pizzaStatusIndex = 0; pizzaStatusIndex < pizzaStatuses.length; pizzaStatusIndex++) {
            timeToDeliveryToEnumValuesMapping.put(
                    pizzaStatuses[pizzaStatusIndex].getTimeToDelivery(),
                    pizzaStatuses[pizzaStatusIndex]
            );
        }
    }

    public static PizzaStatus castIntToEnum(int timeToDelivery) {
        return timeToDeliveryToEnumValuesMapping.get(timeToDelivery);
    }
}
