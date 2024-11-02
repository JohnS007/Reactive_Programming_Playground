package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFutureExample {

    private static final Logger log = LoggerFactory.getLogger(MonoFromFutureExample.class);

    public static void main(String[] args) {

        Mono.fromFuture(MonoFromFutureExample::getRandomName)
                .subscribe(Util.subscriber()); //Try commenting out this line and run the code and observe

        Util.sleepSeconds(1);

    }

    private static CompletableFuture<String> getRandomName(){
        return CompletableFuture
                    .supplyAsync(()-> {
                        log.info(Thread.currentThread().getName());
                        log.info("Generating first name..");
                        return Util.faker().name().firstName();
                    })
                .thenApplyAsync((firstName) -> {
                    log.info(Thread.currentThread().getName());
                    log.info("Generating last name..");
                    return firstName + Util.faker().name().lastName();
                   }
                );
    }

}
