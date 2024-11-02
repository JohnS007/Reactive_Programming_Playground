package com.coding.practice.section_1.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);

    private final Subscriber<? super String> subscriber;
    private static final int MAX_ITEMS = 10;
    private final Faker faker;

    private boolean subscriptionCancelled;
    private int alreadyProducedItems;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requestedItemsCount) {

        if(!subscriptionCancelled){
            log.info("Subscriber has requested {} items from publisher!", requestedItemsCount);

            //Let's do some validation to simulate the working of the case where we face some errori
            if(requestedItemsCount > MAX_ITEMS){
                log.error("The request has failed the validation !!");
                this.subscriber.onError(new RuntimeException("Cannot produce the given amount of items!!"));
                this.subscriptionCancelled = true; //This is the behavior which is expected
            }

            //All good and we can produce
            for(int i=0;i<requestedItemsCount && alreadyProducedItems < MAX_ITEMS;i++){
                alreadyProducedItems += 1;
                this.subscriber.onNext(this.faker.internet().emailAddress());
            }

            //Now we do not have anymore items to produce
            if(alreadyProducedItems == MAX_ITEMS){
                log.info("No more items are there to produce with publisher !");
                this.subscriber.onComplete();
                this.subscriptionCancelled = true; // This can be done logically now !
            }
        }
    }

    @Override
    public void cancel() {
        log.info("Subscriber has requested to cancel its subscription!!");
        this.subscriptionCancelled = true;
    }
}
