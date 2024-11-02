package com.coding.practice.section_1.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherImpl implements Publisher<String> {


    //This is how the subscriber will get subscribed to the publisher..
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {

        //Give the subscription the subscriber object
        var subscription = new SubscriptionImpl(subscriber);

        //Give subscriber the subscription object
        subscriber.onSubscribe(subscription);
    }
}
