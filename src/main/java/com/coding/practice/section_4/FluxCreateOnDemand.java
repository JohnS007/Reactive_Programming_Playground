package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import com.coding.practice.section_1.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class FluxCreateOnDemand {

    private static final Logger log = LoggerFactory.getLogger(FluxCreateOnDemand.class);

    public static void main(String[] args) {
        produceOnDemand();
    }

    private static void produceOnDemand(){

        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(requestCount -> {
                LongStream.rangeClosed(1, requestCount).forEach(itr -> {
                    if(!fluxSink.isCancelled()) {
                        var name = Util.faker().name().firstName();
                        log.info("generated: {}", name);
                        fluxSink.next(name);
                    }
                });
                //If I did early complete then,
                // the future requests from the subscriber even before the subscription is cancelled
                // will not be accepted by the fluxSink
                //fluxSink.complete();

                //When to complete ?
                //When we see the fluxSink.isCancelled() is true
            });

        }).subscribe(subscriber);


        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();
    }

    private static void produceEarly(){
        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            IntStream.rangeClosed(1, 10).forEach(itr -> {
                var name = Util.faker().name().firstName();
                log.info("generated : {}", name);
                //Push the generated name to subscriber using next()
                fluxSink.next(name);
            });
            fluxSink.complete();//Complete after the task.
        }).subscribe(subscriber);

        //Now we don't want anything from producer and directly cancel the subscription
        //So, what will happen ?
        //No data pushed, So why to even generate any name...Correct ?
        //Observe after running the below code

        //subscriber.getSubscription().cancel();

        //By default the Flux.create() will create and push the items in the queue for consumption by the consumer
        //We want everything to be as much lazy as possible but it depends on some business requirements as well
        //By default the producer can produce at max Integer.MAX_VALUE items before MLE error, Or if the object size
        // is too big then it may occur before max size

        //We can utilize the above use case in the following manner

        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().request(2);
        Util.sleepSeconds(2);
        subscriber.getSubscription().cancel();

        //Backpressure handling comes into the picture in the cases like above !!
    }
}
