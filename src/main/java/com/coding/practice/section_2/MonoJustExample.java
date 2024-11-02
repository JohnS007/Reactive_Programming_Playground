package com.coding.practice.section_2;
import com.coding.practice.section_1.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class MonoJustExample {
    public static void main(String[] args) {
        var mono = Mono.just("Johnty");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(1);
    }
}
