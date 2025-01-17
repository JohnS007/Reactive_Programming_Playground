package com.coding.practice.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);
    private final String subscriberName;

    public DefaultSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        log.info("{} Recevied: {}", this.subscriberName, item);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} Error: {}", this.subscriberName, throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} received Complete", this.subscriberName);
    }
}
