package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import com.coding.practice.section_1.publisher.SubscriptionImpl;
import com.coding.practice.section_1.subscriber.SubscriberImpl;
import com.coding.practice.section_3.helper.NameGenerator;

public class FluxVersusListExample {
    public static void main(String[] args) {
//        var list = NameGenerator.getNamesList();
//        System.out.println(list);

        var subscriber = new SubscriberImpl();
        var flux = NameGenerator.getNamesFlux();
        flux.subscribe(subscriber);
        subscriber.getSubscription().request(5);

    }
}
