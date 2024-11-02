package com.coding.practice.section_3.assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StockPricesObserver implements Subscriber<Integer> {

    private final Logger log = LoggerFactory.getLogger(StockPricesObserver.class);
    private Subscription subscription;
    private int balance = 1000;
    private int quantity = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
        this.subscription = subscription;
    }

    @Override
    public void onNext(Integer price) {
        log.info("Received price: {}", price);
        //Need to buy a stock at this price
        if(price < 90 && balance >= price){
            quantity += 1;
            balance -= price;
            log.info("Bought a stock with price: {}. Total quantity now : {}", price, quantity);
        }
        //Now we need to sell all the stocks we have at the price received, This is as per the requirement
        else if(price > 110 && quantity > 0){
            balance += quantity * price;
            log.info("Sold all the {} stocks at the price: {}", quantity, price);
            log.info("Profit made is: {}", balance - 1000);
            subscription.cancel(); //Now we are done with our task
        }
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error: {}", throwable);
    }

    @Override
    public void onComplete() {
        log.info("onComplete() invoked");
    }
}
